package twinsFood.CanaryFoodAPI.interfaces;

import twinsFood.CanaryFoodAPI.dto.review.ReviewRequest;
import twinsFood.CanaryFoodAPI.dto.review.ReviewResponse;
import twinsFood.CanaryFoodAPI.exceptions.Existe;
import twinsFood.CanaryFoodAPI.exceptions.NoExiste;

import java.util.List;

public interface IReviewService {

    public List<ReviewResponse> getReviews();

    List<ReviewResponse> filterReviews(int id);

    public ReviewResponse findReview(int id) throws NoExiste;
    public ReviewResponse addReview(ReviewRequest review) throws Existe;

}
