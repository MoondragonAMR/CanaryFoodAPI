package twinsFood.CanaryFoodAPI.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import twinsFood.CanaryFoodAPI.models.Ingredient;

public interface IngredientRepository extends JpaRepository<Ingredient, Integer> {
}
