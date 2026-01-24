package twinsFood.CanaryFoodAPI.controllers;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import twinsFood.CanaryFoodAPI.dtos.recipe.Filters;
import twinsFood.CanaryFoodAPI.dtos.recipe.RecipeRequest;
import twinsFood.CanaryFoodAPI.exceptions.Existe;
import twinsFood.CanaryFoodAPI.exceptions.NoExiste;
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

    @PostMapping("/")
    public ResponseEntity<?> crear(@Valid @RequestBody RecipeRequest recipe, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(bindingResult.getFieldErrors());
        }
        try{
            return ResponseEntity.status(HttpStatus.CREATED).body(rs.addRecipe(recipe));
        } catch (Existe e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
        }
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> modificar(@PathVariable int id, @Valid @RequestBody RecipeRequest recipe, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(bindingResult.getAllErrors());
        }
        try{
            return ResponseEntity.ok(rs.updateRecipe(recipe, id));
        } catch (Existe e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
        } catch (NoExiste e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable int id) {
        try{
            rs.deleteRecipe(id);
            return ResponseEntity.noContent().build();
        } catch (NoExiste e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
}
