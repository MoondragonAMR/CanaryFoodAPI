package twinsFood.CanaryFoodAPI.interfaces;

import org.springframework.security.core.userdetails.UserDetailsService;
import twinsFood.CanaryFoodAPI.dtos.auth.UserRequest;
import twinsFood.CanaryFoodAPI.dtos.auth.UserResponse;
import twinsFood.CanaryFoodAPI.exceptions.Existe;

import java.util.List;

public interface IUserService extends UserDetailsService {
    UserResponse createUser(UserRequest userRequest) throws Existe;

    List<UserResponse> getUsers();
}
