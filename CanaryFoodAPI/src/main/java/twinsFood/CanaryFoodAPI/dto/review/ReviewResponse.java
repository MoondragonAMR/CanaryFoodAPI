package twinsFood.CanaryFoodAPI.dto.review;

public record ReviewResponse(int id,
                             String title,
                             String description,
                             double rating,
                             String author,
                             RecipeInReviewResponse recipe){}
