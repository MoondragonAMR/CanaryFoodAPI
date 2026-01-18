package twinsFood.CanaryFoodAPI.seeders;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import twinsFood.CanaryFoodAPI.models.Ingredient;
import twinsFood.CanaryFoodAPI.models.Recipe;
import twinsFood.CanaryFoodAPI.models.Review;
import twinsFood.CanaryFoodAPI.repositories.IngredientRepository;
import twinsFood.CanaryFoodAPI.repositories.RecipeRepository;
import twinsFood.CanaryFoodAPI.repositories.ReviewRepository;

@Component
public class RecipeSeeder implements CommandLineRunner {

    @Autowired
    private RecipeRepository rr;
    @Autowired
    private IngredientRepository ir;
    @Autowired
    private ReviewRepository rvr;

    @Override
    public void run(String... args) throws Exception {
        if (ir.findAll().isEmpty()) {
            Ingredient ingredient1 = new Ingredient("Plátanos", "Frutas", true, true, false, false, false, "");
            ir.save(ingredient1);
            Ingredient ingredient2 = new Ingredient("Huevos", "Otros", true, false, false, false, false, "");
            ir.save(ingredient2);
            Ingredient ingredient3 = new Ingredient("Papas", "Verduras", true, true, false, false, false, "");
            ir.save(ingredient3);
            Ingredient ingredient4 = new Ingredient("Piñas de millo", "Verduras", true, true, false, false, false, "");
            ir.save(ingredient4);
            Ingredient ingredient5 = new Ingredient("Costillas de cerdo", "Carne", false, false, false, false, false, "");
            ir.save(ingredient5);
            Ingredient ingredient6 = new Ingredient("Queso", "Otros", true, false, false, false, true, "");
            ir.save(ingredient6);
            Ingredient ingredient7 = new Ingredient("Azúcar", "Otros", true, true, true, false, false, "");
            ir.save(ingredient7);
            Ingredient ingredient8 = new Ingredient("Almendras", "Otros", true, true, false, false, false, "");
            ir.save(ingredient8);
            Ingredient ingredient9 = new Ingredient("Gofio de trigo", "Otros", true, true, false, true, false, "");
            ir.save(ingredient9);
        }
        if (!rr.existsByTitle("Tortitas de plátano")) {
            Recipe recipe1 = new Recipe("Tortitas de plátano", "Desayuno", "Algo", "Algo");
            recipe1.getIngredients().add(ir.findByName("Plátanos"));
            recipe1.getIngredients().add(ir.findByName("Huevos"));
            rr.save(recipe1);
        }
        if (!rr.existsByTitle("Papas, piñas y costillas")) {
            Recipe recipe2 = new Recipe("Papas, piñas y costillas", "Almuerzo o Cena", "Algo", "Algo");
            recipe2.getIngredients().add(ir.findByName("Papas"));
            recipe2.getIngredients().add(ir.findByName("Piñas de millo"));
            recipe2.getIngredients().add(ir.findByName("Costillas de cerdo"));
            rr.save(recipe2);
        }
        if (!rr.existsByTitle("Quesadilla herreña")) {
            Recipe recipe3 = new Recipe("Quesadilla herreña", "Postre", "Algo", "Algo");
            recipe3.getIngredients().add(ir.findByName("Queso"));
            recipe3.getIngredients().add(ir.findByName("Azúcar"));
            rr.save(recipe3);
        }
        if (!rr.existsByTitle("Galletas gomeras")) {
            Recipe recipe4 = new Recipe("Galletas gomeras", "Merienda", "Algo", "Algo");
            recipe4.getIngredients().add(ir.findByName("Huevos"));
            recipe4.getIngredients().add(ir.findByName("Almendras"));
            rr.save(recipe4);
        }
        if (!rr.existsByTitle("Batido de gofio")) {
            Recipe recipe5 = new Recipe("Batido de gofio", "Bebida", "Algo", "Algo");
            recipe5.getIngredients().add(ir.findByName("Gofio de trigo"));
            recipe5.getIngredients().add(ir.findByName("Plátanos"));
            rr.save(recipe5);
        }
        if (rvr.findAll().isEmpty()) {
            rvr.save(new Review("Prueba1", "Algo", 5, rr.findByTitle("Tortitas de plátano")));
            rvr.save(new Review("Prueba2", "Algo", 1, rr.findByTitle("Tortitas de plátano")));
            rvr.save(new Review("Prueba3", "Algo", 5, rr.findByTitle("Papas, piñas y costillas")));
            rvr.save(new Review("Prueba4", "Algo", 1, rr.findByTitle("Papas, piñas y costillas")));
            rvr.save(new Review("Prueba5", "Algo", 5, rr.findByTitle("Quesadilla herreña")));
            rvr.save(new Review("Prueba6", "Algo", 1, rr.findByTitle("Quesadilla herreña")));
            rvr.save(new Review("Prueba7", "Algo", 5, rr.findByTitle("Galletas gomeras")));
            rvr.save(new Review("Prueba8", "Algo", 1, rr.findByTitle("Galletas gomeras")));
            rvr.save(new Review("Prueba9", "Algo", 5, rr.findByTitle("Batido de gofio")));
            rvr.save(new Review("Prueba10", "Algo", 1, rr.findByTitle("Batido de gofio")));
        }
    }
}
