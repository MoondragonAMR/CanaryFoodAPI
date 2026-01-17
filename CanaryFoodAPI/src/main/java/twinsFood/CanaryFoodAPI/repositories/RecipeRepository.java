package twinsFood.CanaryFoodAPI.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import twinsFood.CanaryFoodAPI.models.Recipe;

public interface RecipeRepository extends JpaRepository<Recipe, Integer> {
    public Recipe findByTitle(String title);
}
