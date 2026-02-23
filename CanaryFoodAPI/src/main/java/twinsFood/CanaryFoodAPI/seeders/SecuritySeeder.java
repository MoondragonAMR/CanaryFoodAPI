package twinsFood.CanaryFoodAPI.seeders;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import twinsFood.CanaryFoodAPI.models.Role;
import twinsFood.CanaryFoodAPI.models.User;
import twinsFood.CanaryFoodAPI.repositories.RoleRepository;
import twinsFood.CanaryFoodAPI.repositories.UserRepository;

@Component
public class SecuritySeeder implements CommandLineRunner {

    @Autowired
    private RoleRepository rr;

    @Autowired
    private UserRepository ur;

    @Override
    public void run(String... args) throws Exception {

        if (!rr.existsByName("ROLE_BASIC")) {
            rr.save(new Role("ROLE_BASIC"));
        }

        if (!rr.existsByName("ROLE_PREMIUM")) {
            rr.save(new Role("ROLE_PREMIUM"));
        }

        if (!rr.existsByName("ROLE_ADMIN")) {
            rr.save(new Role("ROLE_ADMIN"));
        }

        if (!ur.existsByDni("123456789A")) {
            ur.save(new User("123456789A", "basic@canaryfood.com", "Basic", "123456789", new BCryptPasswordEncoder().encode("Asdf1234!"), rr.findByName("ROLE_BASIC")));
        }

        if (!ur.existsByDni("234567890B")) {
            User premium = new User("234567890B", "premium@canaryfood.com", "Premium", "234567890", new BCryptPasswordEncoder().encode("Asdf1234!"), rr.findByName("ROLE_PREMIUM"));
            premium.getRoles().add(rr.findByName("ROLE_BASIC"));
            ur.save(premium);
        }

        if (!ur.existsByDni("123456789A")) {
            ur.save(new User("123456789A", "admin@canaryfood.com", "Admin", "123456789", new BCryptPasswordEncoder().encode("Asdf1234!"), rr.findByName("ROLE_ADMIN")));
        }
    }
}
