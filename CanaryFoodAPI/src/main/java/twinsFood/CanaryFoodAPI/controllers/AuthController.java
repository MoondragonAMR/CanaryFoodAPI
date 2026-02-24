package twinsFood.CanaryFoodAPI.controllers;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import twinsFood.CanaryFoodAPI.dtos.auth.LoginRequest;
import twinsFood.CanaryFoodAPI.dtos.auth.LoginResponse;
import twinsFood.CanaryFoodAPI.dtos.auth.UserRequest;
import twinsFood.CanaryFoodAPI.exceptions.Existe;
import twinsFood.CanaryFoodAPI.exceptions.YaPremium;
import twinsFood.CanaryFoodAPI.interfaces.IUserService;
import twinsFood.CanaryFoodAPI.models.User;
import twinsFood.CanaryFoodAPI.repositories.RoleRepository;
import twinsFood.CanaryFoodAPI.repositories.UserRepository;
import twinsFood.CanaryFoodAPI.services.JwtService;

@RestController
@RequestMapping("/api/v1/canaryfood/auth")
public class AuthController {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private IUserService us;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private UserRepository ur;

    @Autowired
    private RoleRepository rr;

    @PreAuthorize("isAnonymous()")
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        Authentication authToken = new UsernamePasswordAuthenticationToken(
                loginRequest.username(),
                loginRequest.password()
        );

        authenticationManager.authenticate(authToken);

        UserDetails user = us.loadUserByUsername(loginRequest.username());

        String token = jwtService.generateToken(user);

        return ResponseEntity.ok(new LoginResponse(token));
    }

    @PreAuthorize("isAnonymous()")
    @PostMapping("/register")
    public ResponseEntity<?> register(@Valid @RequestBody UserRequest user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(bindingResult.getFieldErrors());
        }
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(us.createUser(user));
        } catch (Existe e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
        }
    }

    @PreAuthorize("hasRole('USER') and !hasRole('PREMIUM')")
    @PostMapping("/premium")
    public ResponseEntity<?> premium(@ModelAttribute("user") User user){
        try {
            return ResponseEntity.noContent().build();
        } catch (YaPremium e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Este usuario ya es premium");
        }
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/users")
    public ResponseEntity<?> users() {
        return ResponseEntity.ok(us.getUsers());
    }
}
