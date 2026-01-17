package twinsFood.CanaryFoodAPI.dto.ingredient;

import java.util.ArrayList;

public record RecipeInIngredientResponse(int id,
                                         String title,
                                         String type,
                                         ArrayList<Integer> ingredients,
                                         String steps,
                                         String picture){}
