package twinsFood.CanaryFoodAPI.seeders;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import twinsFood.CanaryFoodAPI.models.Ingredient;
import twinsFood.CanaryFoodAPI.models.Recipe;
import twinsFood.CanaryFoodAPI.repositories.IngredientRepository;
import twinsFood.CanaryFoodAPI.repositories.RecipeRepository;

@Component
public class RecipeSeeder implements CommandLineRunner {

    @Autowired
    private RecipeRepository rr;
    @Autowired
    private IngredientRepository ir;

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
            rr.save(new Recipe("Tortitas de plátano", "Desayuno", "Algo", "Algo"));
            ir.findByName("Plátanos").getRecipes().add(rr.findByTitle("Tortitas de plátano"));
            ir.findByName("Huevos").getRecipes().add(rr.findByTitle("Tortitas de plátano"));
        }
        if (!rr.existsByTitle("Papas, piñas y costillas")) {
            rr.save(new Recipe("Papas, piñas y costillas", "Almuerzo o Cena", "Algo", "Algo"));
            ir.findByName("Papas").getRecipes().add(rr.findByTitle("Papas, piñas y costillas"));
            ir.findByName("Piñas de millo").getRecipes().add(rr.findByTitle("Papas, piñas y costillas"));
            ir.findByName("Costillas de cerdo").getRecipes().add(rr.findByTitle("Papas, piñas y costillas"));
        }
        if (!rr.existsByTitle("Quesadilla herreña")) {
            rr.save(new Recipe("Quesadilla herreña", "Postre", "Algo", "Algo"));
            ir.findByName("Queso").getRecipes().add(rr.findByTitle("Quesadilla herreña"));
            ir.findByName("Azúcar").getRecipes().add(rr.findByTitle("Quesadilla herreña"));
        }
        if (!rr.existsByTitle("Galletas gomeras")) {
            rr.save(new Recipe("Galletas gomeras", "Merienda", "Algo", "Algo"));
            ir.findByName("Huevos").getRecipes().add(rr.findByTitle("Galletas gomeras"));
            ir.findByName("Almendras").getRecipes().add(rr.findByTitle("Galletas gomeras"));
        }
        if (!rr.existsByTitle("Batido de gofio")) {
            rr.save(new Recipe("Batido de gofio", "Bebida", "Algo", "Algo"));
            ir.findByName("Gofio de trigo").getRecipes().add(rr.findByTitle("Batido de gofio"));
            ir.findByName("Plátanos").getRecipes().add(rr.findByTitle("Batido de gofio"));
        }
    }
}
