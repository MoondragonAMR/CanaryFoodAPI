package twinsFood.CanaryFoodAPI.seeders;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import twinsFood.CanaryFoodAPI.models.Review;
import twinsFood.CanaryFoodAPI.repositories.RecipeRepository;
import twinsFood.CanaryFoodAPI.repositories.ReviewRepository;

@Component
public class ReviewSeeder implements CommandLineRunner {

    @Autowired
    private ReviewRepository rvr;
    @Autowired
    private RecipeRepository rr;

    @Override
    public void run(String... args) throws Exception {
        if (rvr.findAll().isEmpty()) {
            rvr.save(new Review("Prueba1", "", 5, rr.findByTitle("Tortitas de plátano")));
            rvr.save(new Review("Prueba2", "", 1, rr.findByTitle("Tortitas de plátano")));
            rvr.save(new Review("Prueba3", "", 5, rr.findByTitle("Papas, piñas y costillas")));
            rvr.save(new Review("Prueba4", "", 1, rr.findByTitle("Papas, piñas y costillas")));
            rvr.save(new Review("Prueba5", "", 5, rr.findByTitle("Quesadilla herreña")));
            rvr.save(new Review("Prueba6", "", 1, rr.findByTitle("Quesadilla herreña")));
            rvr.save(new Review("Prueba7", "", 5, rr.findByTitle("Galletas gomeras")));
            rvr.save(new Review("Prueba8", "", 1, rr.findByTitle("Galletas gomeras")));
            rvr.save(new Review("Prueba9", "", 5, rr.findByTitle("Batido de gofio")));
            rvr.save(new Review("Prueba10", "", 1, rr.findByTitle("Batido de gofio")));
        }
    }
}
