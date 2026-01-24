package twinsFood.CanaryFoodAPI.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import twinsFood.CanaryFoodAPI.dtos.review.RecipeInReviewResponse;
import twinsFood.CanaryFoodAPI.dtos.review.ReviewRequest;
import twinsFood.CanaryFoodAPI.dtos.review.ReviewResponse;
import twinsFood.CanaryFoodAPI.exceptions.Existe;
import twinsFood.CanaryFoodAPI.exceptions.NoExiste;
import twinsFood.CanaryFoodAPI.interfaces.IReviewService;
import twinsFood.CanaryFoodAPI.models.Review;
import twinsFood.CanaryFoodAPI.repositories.RecipeRepository;
import twinsFood.CanaryFoodAPI.repositories.ReviewRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class ReviewService implements IReviewService {

    @Autowired
    private ReviewRepository rvr;
    @Autowired
    private RecipeRepository rr;

    @Override
    public List<ReviewResponse> getReviews() {
        List<Review> reviews = rvr.findAll();
        List<ReviewResponse> reviewsResponse = new ArrayList<>();
        reviews.forEach(review -> {
            ArrayList<Integer> reviewsRecipe = new ArrayList<>();
            review.getRecipe().getReviews().forEach(reviewrecipe -> {
                reviewsRecipe.add(reviewrecipe.getId());
            });
            RecipeInReviewResponse recipe = new RecipeInReviewResponse(review.getRecipe().getId(), review.getRecipe().getTitle(),
                    review.getRecipe().getType(), review.getRecipe().getSteps(), review.getRecipe().getPicture(), reviewsRecipe);
            reviewsResponse.add(new ReviewResponse(review.getId(), review.getTitle(), review.getDescription(), review.getRating(), review.getAuthor(), recipe));
        });
        return reviewsResponse;
    }

    @Override
    public List<ReviewResponse> filterReviews(int id) {
        List<Review> reviews = rvr.findAll();
        List<ReviewResponse> reviewsResponse = new ArrayList<>();
        reviews.forEach(review -> {
            if(review.getRecipe().getId() == id) {
                ArrayList<Integer> reviewsRecipe = new ArrayList<>();
                review.getRecipe().getReviews().forEach(reviewrecipe -> {
                    reviewsRecipe.add(reviewrecipe.getId());
                });
                RecipeInReviewResponse recipe = new RecipeInReviewResponse(review.getRecipe().getId(), review.getRecipe().getTitle(),
                        review.getRecipe().getType(), review.getRecipe().getSteps(), review.getRecipe().getPicture(), reviewsRecipe);
                reviewsResponse.add(new ReviewResponse(review.getId(), review.getTitle(), review.getDescription(), review.getRating(), review.getAuthor(), recipe));
            }
        });
        return reviewsResponse;
    }

    @Override
    public ReviewResponse findReview(int id) throws NoExiste {
        Review review = rvr.findById(id).orElse(null);
        if (review == null) throw new NoExiste("No existe ningún comentario con ese id");
        ArrayList<Integer> reviewsRecipe = new ArrayList<>();
        review.getRecipe().getReviews().forEach(reviewrecipe -> {
            reviewsRecipe.add(reviewrecipe.getId());
        });
        RecipeInReviewResponse recipe = new RecipeInReviewResponse(review.getRecipe().getId(), review.getRecipe().getTitle(),
                review.getRecipe().getType(), review.getRecipe().getSteps(), review.getRecipe().getPicture(), reviewsRecipe);
        return new ReviewResponse(review.getId(), review.getTitle(), review.getDescription(), review.getRating(), review.getAuthor(), recipe);
    }

    @Override
    public ReviewResponse addReview(ReviewRequest review) throws Existe {
        final boolean[] correcto = {true};
        getReviews().forEach(encontrado -> {
            if (encontrado.title().matches(review.title())){
                correcto[0] = false;
            }
        });
        if (correcto[0]) {
            Review finalReview = new Review(review.title(), review.description(), review.rating(), review.author(), rr.findById(review.recipe()).orElse(null));
            rvr.save(finalReview);
        }else{
            throw new Existe("Ya existe un comentario con ese título");
        }
        return findReview(rvr.findByTitle(review.title()).getId());
    }
}
