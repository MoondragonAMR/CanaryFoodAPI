package twinsFood.CanaryFoodAPI.interfaces;

import twinsFood.CanaryFoodAPI.dto.review.ReviewRequest;
import twinsFood.CanaryFoodAPI.dto.review.ReviewResponse;
import twinsFood.CanaryFoodAPI.exceptions.Existe;

import java.util.List;

public interface IReviewService {

    public List<ReviewResponse> getReviews();
    public ReviewResponse addReview(ReviewRequest review) throws Existe;

}
