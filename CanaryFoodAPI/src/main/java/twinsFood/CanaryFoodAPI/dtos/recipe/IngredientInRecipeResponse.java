package twinsFood.CanaryFoodAPI.dtos.recipe;

import java.util.ArrayList;

public record IngredientInRecipeResponse(int id,
                                         String name,
                                         String type, ArrayList<Integer> recipes){}
