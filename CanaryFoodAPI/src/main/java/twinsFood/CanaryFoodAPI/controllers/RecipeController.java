package twinsFood.CanaryFoodAPI.controllers;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import twinsFood.CanaryFoodAPI.dtos.recipe.Filters;
import twinsFood.CanaryFoodAPI.dtos.recipe.RecipeRequest;
import twinsFood.CanaryFoodAPI.exceptions.Existe;
import twinsFood.CanaryFoodAPI.exceptions.NoExiste;
import twinsFood.CanaryFoodAPI.exceptions.NoTuya;
import twinsFood.CanaryFoodAPI.services.RecipeService;

@RestController
@RequestMapping("/api/v1/canaryfood/recipes")
public class RecipeController {
    @Autowired
    private RecipeService rs;

    @GetMapping("/")
    public ResponseEntity<?> listar(@RequestBody Filters filters) {
        return ResponseEntity.ok(rs.getRecipes(filters));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> mostrar(@PathVariable int id) {
        try{
            return ResponseEntity.ok(rs.findRecipe(id));
        } catch (NoExiste e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @PreAuthorize("hasRole('ADMIN') or hasRole('PREMIUM')")
    @PostMapping("/")
    public ResponseEntity<?> crear(@Valid @RequestBody RecipeRequest recipe, BindingResult bindingResult, Authentication auth) {
        if (bindingResult.hasErrors()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(bindingResult.getFieldErrors());
        }
        try{
            String name = auth.getName();
            return ResponseEntity.status(HttpStatus.CREATED).body(rs.addRecipe(recipe, name));
        } catch (Existe e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
        }
    }

    @PreAuthorize("hasRole('ADMIN') or hasRole('PREMIUM')")
    @PutMapping("/{id}")
    public ResponseEntity<?> modificar(@PathVariable int id, @Valid @RequestBody RecipeRequest recipe, BindingResult bindingResult, Authentication auth) {
        if (bindingResult.hasErrors()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(bindingResult.getAllErrors());
        }
        try{
            String name = auth.getName();
            return ResponseEntity.ok(rs.updateRecipe(recipe, id, name));
        } catch (Existe e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
        } catch (NoExiste e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        } catch (NoTuya nt) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(nt.getMessage());
        }
    }

    @PreAuthorize("hasRole('ADMIN') or hasRole('PREMIUM')")
    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable int id, Authentication auth) {
        try{
            String name = auth.getName();
            rs.deleteRecipe(id, name);
            return ResponseEntity.noContent().build();
        } catch (NoExiste e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        } catch (NoTuya nt) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(nt.getMessage());
        }
    }
}
