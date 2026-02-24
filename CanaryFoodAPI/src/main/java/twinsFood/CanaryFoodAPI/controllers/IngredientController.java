package twinsFood.CanaryFoodAPI.controllers;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import twinsFood.CanaryFoodAPI.dtos.ingredient.IngredientRequest;
import twinsFood.CanaryFoodAPI.exceptions.Existe;
import twinsFood.CanaryFoodAPI.exceptions.NoExiste;
import twinsFood.CanaryFoodAPI.services.IngredientService;

@RestController
@RequestMapping("/api/v1/canaryfood/ingredients")
public class IngredientController {
    @Autowired
    private IngredientService is;

    @GetMapping("/")
    public ResponseEntity<?> listar() {
        return ResponseEntity.ok(is.getIngredients());
    }

    @GetMapping("/filter")
    public ResponseEntity<?> filtrar(@RequestParam int recipe) {
        return ResponseEntity.ok(is.filterIngredients(recipe));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> mostrar(@PathVariable int id) {
        try{
            return ResponseEntity.ok(is.findIngredient(id));
        } catch (NoExiste e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @PreAuthorize("hasRole('ADMIN') or hasRole('PREMIUM')")
    @PostMapping("/")
    public ResponseEntity<?> crear(@Valid @RequestBody IngredientRequest ingredient, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(bindingResult.getFieldErrors());
        }
        try{
            return ResponseEntity.status(HttpStatus.CREATED).body(is.addIngredient(ingredient));
        } catch (Existe e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
        }
    }
}
