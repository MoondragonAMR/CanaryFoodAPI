package twinsFood.CanaryFoodAPI.dtos.recipe;

public record ReviewInRecipeResponse(int id,
                                     String title,
                                     String description,
                                     double rating,
                                     String author,
                                     int recipe){}
