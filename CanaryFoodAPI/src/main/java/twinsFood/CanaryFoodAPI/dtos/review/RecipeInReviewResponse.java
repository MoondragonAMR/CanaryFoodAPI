package twinsFood.CanaryFoodAPI.dtos.review;

import java.util.ArrayList;

public record RecipeInReviewResponse(int id,
                                     String title,
                                     String type,
                                     String steps,
                                     String picture,
                                     ArrayList<Integer> reviews){}
