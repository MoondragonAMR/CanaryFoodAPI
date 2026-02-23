package twinsFood.CanaryFoodAPI.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import twinsFood.CanaryFoodAPI.models.Role;

public interface RoleRepository extends JpaRepository<Role, Integer> {
    Role findByName(String role);

    boolean existsByName(String role);
}
