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
            if (!rr.existsByTitle("Tortitas de plátano")) {
                rr.save(new Recipe("Tortitas de plátano", "Desayuno", "", ""));
            }
            ingredient1.getRecipes().add(rr.findByTitle("Tortitas de plátano"));
            if (!rr.existsByTitle("Batido de gofio")) {
                rr.save(new Recipe("Batido de gofio", "Bebida", "", ""));
            }
            ingredient1.getRecipes().add(rr.findByTitle("Batido de gofio"));
            ir.save(ingredient1);
            Ingredient ingredient2 = new Ingredient("Huevos", "Otros", true, false, false, false, false, "");
            ingredient2.getRecipes().add(rr.findByTitle("Tortitas de plátano"));
            if (!rr.existsByTitle("Galletas gomeras")) {
                rr.save(new Recipe("Galletas gomeras", "Merienda", "", ""));
            }
            ingredient2.getRecipes().add(rr.findByTitle("Galletas gomeras"));
            ir.save(ingredient2);
            Ingredient ingredient3 = new Ingredient("Papas", "Verduras", true, true, false, false, false, "");
            if (!rr.existsByTitle("Papas, piñas y costillas")) {
                rr.save(new Recipe("Papas, piñas y costillas", "Almuerzo/Cena", "", ""));
            }
            ingredient3.getRecipes().add(rr.findByTitle("Papas, piñas y costillas"));
            ir.save(ingredient3);
            Ingredient ingredient4 = new Ingredient("Piñas de millo", "Verduras", true, true, false, false, false, "");
            ingredient4.getRecipes().add(rr.findByTitle("Papas, piñas y costillas"));
            ir.save(ingredient4);
            Ingredient ingredient5 = new Ingredient("Costillas de cerdo", "Carne", false, false, false, false, false, "");
            ingredient5.getRecipes().add(rr.findByTitle("Papas, piñas y costillas"));
            ir.save(ingredient5);
            Ingredient ingredient6 = new Ingredient("Queso", "Otros", true, false, false, false, true, "");
            if (!rr.existsByTitle("Quesadilla herreña")) {
                rr.save(new Recipe("Quesadilla herreña", "Postre", "", ""));
            }
            ingredient6.getRecipes().add(rr.findByTitle("Quesadilla herreña"));
            ir.save(ingredient6);
            Ingredient ingredient7 = new Ingredient("Azúcar", "Otros", true, true, true, false, false, "");
            ingredient7.getRecipes().add(rr.findByTitle("Quesadilla herreña"));
            ir.save(ingredient7);
            Ingredient ingredient8 = new Ingredient("Almendras", "Otros", true, true, false, false, false, "");
            ingredient8.getRecipes().add(rr.findByTitle("Galletas gomeras"));
            ir.save(ingredient8);
            Ingredient ingredient9 = new Ingredient("Gofio de trigo", "Otros", true, true, false, true, false, "");
            ingredient9.getRecipes().add(rr.findByTitle("Batido de gofio"));
            ir.save(ingredient9);
        }
    }
}
