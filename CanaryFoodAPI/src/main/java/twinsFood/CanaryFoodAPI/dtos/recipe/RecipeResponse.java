package twinsFood.CanaryFoodAPI.dtos.recipe;

import java.util.List;

public record RecipeResponse(int id, String title,
                             String type,
                             List<IngredientInRecipeResponse> ingredients,
                             String steps,
                             String picture,
                             List<ReviewInRecipeResponse> reviews){}
