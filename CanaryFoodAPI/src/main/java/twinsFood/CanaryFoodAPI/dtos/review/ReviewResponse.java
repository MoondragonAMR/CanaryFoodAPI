package twinsFood.CanaryFoodAPI.dtos.review;

public record ReviewResponse(int id,
                             String title,
                             String description,
                             double rating,
                             String author,
                             RecipeInReviewResponse recipe){}
