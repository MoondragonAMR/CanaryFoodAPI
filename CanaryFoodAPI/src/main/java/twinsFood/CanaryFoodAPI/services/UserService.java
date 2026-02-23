package twinsFood.CanaryFoodAPI.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import twinsFood.CanaryFoodAPI.dtos.auth.UserRequest;
import twinsFood.CanaryFoodAPI.dtos.auth.UserResponse;
import twinsFood.CanaryFoodAPI.exceptions.Existe;
import twinsFood.CanaryFoodAPI.interfaces.IUserService;
import twinsFood.CanaryFoodAPI.models.User;
import twinsFood.CanaryFoodAPI.repositories.RoleRepository;
import twinsFood.CanaryFoodAPI.repositories.UserRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class UserService implements IUserService {

    @Autowired
    private UserRepository ur;

    @Autowired
    private RoleRepository rr;

    @Override
    public UserResponse createUser(UserRequest userRequest) throws Existe {
        final boolean[] correcto = {true};
        ur.findAll().forEach(found -> {
            if (found.getDni().matches(userRequest.dni()) || found.getEmail().matches(userRequest.email())) {
                correcto[0] = false;
            }
        });
        User user = new User();
        if (correcto[0]) {
            user.setDni(userRequest.dni());
            user.setEmail(userRequest.email());
            user.setNombreCompleto(userRequest.nombreCompleto());
            user.setTlf(userRequest.tlf());
            user.setPassword(new BCryptPasswordEncoder().encode(userRequest.password()));
            user.getRoles().add(rr.findByName("ROLE_ALUMNO"));
            ur.save(user);
        }  else {
            if (user.getDni().matches(userRequest.dni()) && user.getEmail().matches(userRequest.email())) {
                throw new Existe("Ya existe un usuario con ese dni e email");
            } else if (user.getDni().matches(userRequest.dni())) {
                throw new Existe("Ya existe un usuario con ese dni");
            } else {
                throw new Existe("Ya existe un usuario con ese email");
            }
        }
        ur.save(user);
        ArrayList<String> roles = new ArrayList<>();
        user.getRoles().forEach(role -> {
            roles.add(role.getName());
        });
        return new UserResponse(user.getId(), user.getDni(), user.getEmail(), user.getNombreCompleto(), user.getTlf(), roles);
    }

    @Override
    public List<UserResponse> getUsers() {
        List<User> users = ur.findAll();
        List<UserResponse> usersResponse = new ArrayList<>();
        users.forEach(user -> {
            ArrayList<String> roles = new ArrayList<>();
            user.getRoles().forEach(role -> {
                roles.add(role.getName());
            });
            usersResponse.add(new UserResponse(user.getId(), user.getDni(), user.getEmail(), user.getNombreCompleto(), user.getTlf(), roles));
        });
        return usersResponse;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = ur.findByDni(username);
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        Objects.requireNonNull(user).getRoles().forEach(role -> {
            authorities.add(new SimpleGrantedAuthority(role.getName()));
        });
        return new org.springframework.security.core.userdetails.User(
                username,
                user.getPassword(),
                true,
                true,
                true,
                true,
                authorities
        );
    }
}
