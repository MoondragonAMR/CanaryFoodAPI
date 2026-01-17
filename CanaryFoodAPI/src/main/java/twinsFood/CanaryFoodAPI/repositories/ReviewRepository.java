package twinsFood.CanaryFoodAPI.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import twinsFood.CanaryFoodAPI.models.Review;

public interface ReviewRepository extends JpaRepository<Review, Integer> {
}
