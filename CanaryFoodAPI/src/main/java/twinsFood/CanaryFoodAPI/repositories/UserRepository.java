package twinsFood.CanaryFoodAPI.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import twinsFood.CanaryFoodAPI.models.User;

public interface UserRepository extends JpaRepository<User, Integer> {
    User findByDni(String username);

    boolean existsByDni(String dni);
}
