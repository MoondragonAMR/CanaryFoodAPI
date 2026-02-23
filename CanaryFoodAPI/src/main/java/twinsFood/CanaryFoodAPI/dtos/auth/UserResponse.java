package twinsFood.CanaryFoodAPI.dtos.auth;

import java.util.List;

public record UserResponse(int id,
                           String dni,
                           String email,
                           String nombreCompleto,
                           String tlf,
                           List<String> roles) {
}
