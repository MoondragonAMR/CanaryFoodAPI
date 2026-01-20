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
            Ingredient ingredient1 = new Ingredient("Gofio de millo", "Otros", true, true, false, false, false, "");
            ir.save(ingredient1);
            Ingredient ingredient2 = new Ingredient("Huevos", "Otros", true, false, false, false, false, "");
            ir.save(ingredient2);
            Ingredient ingredient3 = new Ingredient("Claras de huevo", "Otros", true, false, false, false, false, "");
            ir.save(ingredient3);
            Ingredient ingredient4 = new Ingredient("Stevia", "Otros", true, true, false, false, false, "");
            ir.save(ingredient4);
            Ingredient ingredient5 = new Ingredient("Canela en polvo", "Otros", true, true, false, false, false, "");
            ir.save(ingredient5);
            Ingredient ingredient6 = new Ingredient("Levadura en polvo", "Otros", true, true, false, false, false, "");
            ir.save(ingredient6);
            Ingredient ingredient7 = new Ingredient("Esencia de vainilla", "Otros", true, true, false, false, false, "");
            ir.save(ingredient7);
            Ingredient ingredient8 = new Ingredient("Semillas de chia", "Frutos secos", true, true, false, false, false, "");
            ir.save(ingredient8);
            Ingredient ingredient9 = new Ingredient("Leche", "Otros", true, false, false, false, true, "");
            ir.save(ingredient9);
            Ingredient ingredient10 = new Ingredient("Aceite de oliva", "Otros", true, true, false, false, false, "");
            ir.save(ingredient10);
            Ingredient ingredient11 = new Ingredient("Frambuesas", "Frutas", true, true, false, false, false, "");
            ir.save(ingredient11);
            Ingredient ingredient12 = new Ingredient("Sirope de agave", "Otros", true, true, false, false, false, "");
            ir.save(ingredient12);
            Ingredient ingredient13 = new Ingredient("Papas nuevas", "Verduras", true, true, false, false, false, "");
            ir.save(ingredient13);
            Ingredient ingredient14 = new Ingredient("Piñas de millo", "Verduras", true, true, false, false, false, "");
            ir.save(ingredient14);
            Ingredient ingredient15 = new Ingredient("Costillas saladas de cerdo", "Carne", false, false, false, false, false, "");
            ir.save(ingredient15);
            Ingredient ingredient16 = new Ingredient("Azafrán", "Otros", true, true, false, false, false, "");
            ir.save(ingredient16);
            Ingredient ingredient17 = new Ingredient("Agua", "Otros", true, true, false, false, false, "");
            ir.save(ingredient17);
            Ingredient ingredient18 = new Ingredient("Sal", "Otros", true, true, false, false, false, "");
            ir.save(ingredient18);
            Ingredient ingredient19 = new Ingredient("Cilantro", "Verduras", true, true, false, false, false, "");
            ir.save(ingredient19);
            Ingredient ingredient20 = new Ingredient("Dientes de ajo", "Verduras", true, true, false, false, false, "");
            ir.save(ingredient20);
            Ingredient ingredient21 = new Ingredient("Comino en grano", "Frutos secos", true, true, false, false, false, "");
            ir.save(ingredient21);
            Ingredient ingredient22 = new Ingredient("Vinagre de vino blanco", "Otros", true, true, false, false, false, "");
            ir.save(ingredient22);
            Ingredient ingredient23 = new Ingredient("Pimienta", "Otros", true, true, false, false, false, "");
            ir.save(ingredient23);
            Ingredient ingredient24 = new Ingredient("Queso fresco", "Otros", true, false, false, false, true, "");
            ir.save(ingredient24);
            Ingredient ingredient25 = new Ingredient("Harina", "Otros", true, true, false, true, false, "");
            ir.save(ingredient25);
            Ingredient ingredient26 = new Ingredient("Miel", "Otros", true, true, false, false, false, "");
            ir.save(ingredient26);
            Ingredient ingredient27 = new Ingredient("Azúcar", "Otros", true, true, true, false, false, "");
            ir.save(ingredient27);
            Ingredient ingredient28 = new Ingredient("Piel de limón picada", "Frutas", true, true, false, false, false, "");
            ir.save(ingredient28);
            Ingredient ingredient29 = new Ingredient("Anís en grano", "Frutos secos", true, true, false, false, false, "");
            ir.save(ingredient29);
            Ingredient ingredient30 = new Ingredient("Mantequilla", "Otros", true, true, false, false, true, "");
            ir.save(ingredient30);
            Ingredient ingredient31 = new Ingredient("Aceite de maíz", "Otros", true, true, false, false, false, "");
            ir.save(ingredient31);
            Ingredient ingredient32 = new Ingredient("Limón rallado", "Frutas", true, true, false, false, false, "");
            ir.save(ingredient32);
            Ingredient ingredient33 = new Ingredient("Plátanos de Canarias", "Frutas", true, true, false, false, false, "");
            ir.save(ingredient33);
            Ingredient ingredient34 = new Ingredient("Leche desnatada", "Otros", true, true, false, false, true, "");
            ir.save(ingredient34);
            Ingredient ingredient35 = new Ingredient("Crema de cacahuete", "Frutos secos", true, true, false, false, false, "");
            ir.save(ingredient35);
        }
        if (!rr.existsByTitle("Tortitas de gofio")) {
            Recipe recipe1 = new Recipe("Tortitas de gofio", "Desayuno", "Algo", "Algo");
            recipe1.getIngredients().add(ir.findByName("Gofio de millo"));
            recipe1.getIngredients().add(ir.findByName("Huevos"));
            recipe1.getIngredients().add(ir.findByName("Claras de huevo"));
            recipe1.getIngredients().add(ir.findByName("Stevia"));
            recipe1.getIngredients().add(ir.findByName("Canela en polvo"));
            recipe1.getIngredients().add(ir.findByName("Levadura en polvo"));
            recipe1.getIngredients().add(ir.findByName("Esencia de vainilla"));
            recipe1.getIngredients().add(ir.findByName("Semillas de chia"));
            recipe1.getIngredients().add(ir.findByName("Leche"));
            recipe1.getIngredients().add(ir.findByName("Aceite de oliva"));
            recipe1.getIngredients().add(ir.findByName("Frambuesas"));
            recipe1.getIngredients().add(ir.findByName("Sirope de agave"));
            rr.save(recipe1);
        }
        if (!rr.existsByTitle("Papas, piñas y costillas")) {
            Recipe recipe2 = new Recipe("Papas, piñas y costillas", "Almuerzo o Cena", "Algo", "Algo");
            recipe2.getIngredients().add(ir.findByName("Papas nuevas"));
            recipe2.getIngredients().add(ir.findByName("Piñas de millo"));
            recipe2.getIngredients().add(ir.findByName("Costillas saladas de cerdo"));
            recipe2.getIngredients().add(ir.findByName("Azafrán"));
            recipe2.getIngredients().add(ir.findByName("Agua"));
            recipe2.getIngredients().add(ir.findByName("Sal"));
            recipe2.getIngredients().add(ir.findByName("Cilantro"));
            recipe2.getIngredients().add(ir.findByName("Dientes de ajo"));
            recipe2.getIngredients().add(ir.findByName("Comino en grano"));
            recipe2.getIngredients().add(ir.findByName("Aceite de oliva"));
            recipe2.getIngredients().add(ir.findByName("Vinagre de vino blanco"));
            recipe2.getIngredients().add(ir.findByName("Pimienta"));
            rr.save(recipe2);
        }
        if (!rr.existsByTitle("Quesadilla herreña")) {
            Recipe recipe3 = new Recipe("Quesadilla herreña", "Postre", "Algo", "Algo");
            recipe3.getIngredients().add(ir.findByName("Queso fresco"));
            recipe3.getIngredients().add(ir.findByName("Harina"));
            recipe3.getIngredients().add(ir.findByName("Miel"));
            recipe3.getIngredients().add(ir.findByName("Azúcar"));
            recipe3.getIngredients().add(ir.findByName("Huevos"));
            recipe3.getIngredients().add(ir.findByName("Piel de limón picada"));
            recipe3.getIngredients().add(ir.findByName("Anís en grano"));
            recipe3.getIngredients().add(ir.findByName("Canela en polvo"));
            recipe3.getIngredients().add(ir.findByName("Mantequilla"));
            rr.save(recipe3);
        }
        if (!rr.existsByTitle("Galletas gomeras")) {
            Recipe recipe4 = new Recipe("Galletas gomeras", "Merienda", "Algo", "Algo");
            recipe4.getIngredients().add(ir.findByName("Huevos"));
            recipe4.getIngredients().add(ir.findByName("Azúcar"));
            recipe4.getIngredients().add(ir.findByName("Harina"));
            recipe4.getIngredients().add(ir.findByName("Levadura en polvo"));
            recipe4.getIngredients().add(ir.findByName("Mantequilla"));
            recipe4.getIngredients().add(ir.findByName("Leche"));
            recipe4.getIngredients().add(ir.findByName("Agua"));
            recipe4.getIngredients().add(ir.findByName("Canela en polvo"));
            recipe4.getIngredients().add(ir.findByName("Aceite de maíz"));
            recipe4.getIngredients().add(ir.findByName("Limón rallado"));
            rr.save(recipe4);
        }
        if (!rr.existsByTitle("Batido de gofio")) {
            Recipe recipe5 = new Recipe("Batido de gofio", "Bebida", "Algo", "Algo");
            recipe5.getIngredients().add(ir.findByName("Gofio de millo"));
            recipe5.getIngredients().add(ir.findByName("Plátanos de Canarias"));
            recipe5.getIngredients().add(ir.findByName("Leche desnatada"));
            recipe5.getIngredients().add(ir.findByName("Crema de cacahuete"));
            rr.save(recipe5);
        }
        if (rvr.findAll().isEmpty()) {
            rvr.save(new Review("Prueba1", "Algo", 5, rr.findByTitle("Tortitas de gofio")));
            rvr.save(new Review("Prueba2", "Algo", 1, rr.findByTitle("Tortitas de gofio")));
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
