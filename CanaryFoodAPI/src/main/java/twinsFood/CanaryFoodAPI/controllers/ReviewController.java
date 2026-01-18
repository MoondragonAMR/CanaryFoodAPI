package twinsFood.CanaryFoodAPI.controllers;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import twinsFood.CanaryFoodAPI.dto.review.ReviewRequest;
import twinsFood.CanaryFoodAPI.exceptions.Existe;
import twinsFood.CanaryFoodAPI.exceptions.NoExiste;
import twinsFood.CanaryFoodAPI.services.ReviewService;

@RestController
@RequestMapping("/api/v1/canaryfood/reviews")
public class ReviewController {
    @Autowired
    private ReviewService rvs;

    @GetMapping("/")
    public ResponseEntity<?> listar() {
        return ResponseEntity.ok(rvs.getReviews());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> mostrar(@PathVariable int id) {
        try{
            return ResponseEntity.ok(rvs.findReview(id));
        } catch (NoExiste e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @PostMapping("/")
    public ResponseEntity<?> crear(@Valid @RequestBody ReviewRequest review, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(bindingResult.getFieldErrors());
        }
        try{
            return ResponseEntity.status(HttpStatus.CREATED).body(rvs.addReview(review));
        } catch (Existe e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
        }
    }
}
