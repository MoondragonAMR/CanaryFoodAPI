package twinsFood.CanaryFoodAPI.dtos.ingredient;

import java.util.ArrayList;

public record IngredientResponse(int id,
                                 String name,
                                 String type,
                                 boolean vegetarian,
                                 boolean vegan,
                                 boolean sugar,
                                 boolean gluten,
                                 boolean dairy,
                                 String picture,
                                 ArrayList<RecipeInIngredientResponse> recipes){}
