package twinsFood.CanaryFoodAPI.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import twinsFood.CanaryFoodAPI.dtos.ingredient.IngredientRequest;
import twinsFood.CanaryFoodAPI.dtos.ingredient.IngredientResponse;
import twinsFood.CanaryFoodAPI.dtos.ingredient.RecipeInIngredientResponse;
import twinsFood.CanaryFoodAPI.exceptions.Existe;
import twinsFood.CanaryFoodAPI.exceptions.NoExiste;
import twinsFood.CanaryFoodAPI.interfaces.IIngredientService;
import twinsFood.CanaryFoodAPI.models.Ingredient;
import twinsFood.CanaryFoodAPI.models.Recipe;
import twinsFood.CanaryFoodAPI.repositories.IngredientRepository;
import twinsFood.CanaryFoodAPI.repositories.RecipeRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class IngredientService implements IIngredientService {

    @Autowired
    private IngredientRepository ir;

    @Autowired
    private RecipeRepository rr;

    @Override
    public List<IngredientResponse> getIngredients() {
        List<Ingredient> ingredients = ir.findAll();
        List<IngredientResponse> ingredientsResponse = new ArrayList<>();
        ingredients.forEach(ingredient -> {
            ArrayList<RecipeInIngredientResponse> recipes = new ArrayList<>();
            ingredient.getRecipes().forEach(recipe -> {
                ArrayList<Integer> ingredientsRecipe = new ArrayList<>();
                recipe.getIngredients().forEach(ingredientrecipe -> {
                    ingredientsRecipe.add(ingredientrecipe.getId());
                });
                recipes.add(new RecipeInIngredientResponse(recipe.getId(), recipe.getTitle(),
                        recipe.getType(), ingredientsRecipe, recipe.getSteps(), recipe.getPicture()));
            });
            ingredientsResponse.add(new IngredientResponse(ingredient.getId(), ingredient.getName(), ingredient.getType(), ingredient.isVegetarian(),
                    ingredient.isVegan(), ingredient.isSugar(), ingredient.isGluten(), ingredient.isDairy(), ingredient.getPicture(), recipes));
        });
        return ingredientsResponse;
    }

    @Override
    public List<IngredientResponse> filterIngredients(int id) {
        List<Ingredient> ingredients = ir.findAll();
        List<IngredientResponse> ingredientsResponse = new ArrayList<>();
        ingredients.forEach(ingredient -> {
            ArrayList<RecipeInIngredientResponse> recipes = new ArrayList<>();
            final boolean[] mostrar = {false};
            ingredient.getRecipes().forEach(recipe -> {
                if (recipe.getId() == id) {
                    mostrar[0] = true;
                }
                ArrayList<Integer> ingredientsRecipe = new ArrayList<>();
                recipe.getIngredients().forEach(ingredientrecipe -> {
                    ingredientsRecipe.add(ingredientrecipe.getId());
                });
                recipes.add(new RecipeInIngredientResponse(recipe.getId(), recipe.getTitle(),
                        recipe.getType(), ingredientsRecipe, recipe.getSteps(), recipe.getPicture()));
            });
            if (mostrar[0]) {
                ingredientsResponse.add(new IngredientResponse(ingredient.getId(), ingredient.getName(), ingredient.getType(), ingredient.isVegetarian(),
                        ingredient.isVegan(), ingredient.isSugar(), ingredient.isGluten(), ingredient.isDairy(), ingredient.getPicture(), recipes));
            }
        });
        return ingredientsResponse;
    }

    @Override
    public IngredientResponse findIngredient(int id) throws NoExiste {
        Ingredient ingredient = ir.findById(id).orElse(null);
        if (ingredient == null) throw new NoExiste("No existe ningún ingrediente con ese id");
        ArrayList<RecipeInIngredientResponse> recipes = new ArrayList<>();
        ingredient.getRecipes().forEach(recipe -> {
            ArrayList<Integer> ingredientsRecipe = new ArrayList<>();
            recipe.getIngredients().forEach(ingredientrecipe -> {
                ingredientsRecipe.add(ingredientrecipe.getId());
            });
            recipes.add(new RecipeInIngredientResponse(recipe.getId(), recipe.getTitle(),
                    recipe.getType(), ingredientsRecipe, recipe.getSteps(), recipe.getPicture()));
        });
        return new IngredientResponse(ingredient.getId(), ingredient.getName(), ingredient.getType(), ingredient.isVegetarian(),
                ingredient.isVegan(), ingredient.isSugar(), ingredient.isGluten(), ingredient.isDairy(), ingredient.getPicture(), recipes);
    }

    @Override
    public IngredientResponse addIngredient(IngredientRequest ingredient) throws Existe {
        final boolean[] correcto = {true};
        getIngredients().forEach(encontrado -> {
            if (encontrado.name().matches(ingredient.name())){
                correcto[0] = false;
            }
        });
        if (correcto[0]) {
            Ingredient finalIngredient = new Ingredient(ingredient.name(), ingredient.type(), ingredient.vegetarian(), ingredient.vegan(), ingredient.sugar(), ingredient.gluten(), ingredient.dairy(), ingredient.picture());
            finalIngredient.getRecipes().add(rr.findById(ingredient.recipe()).orElse(null));
            ir.save(finalIngredient);
            Recipe recipe = rr.findById(ingredient.recipe()).orElse(null);
            assert recipe != null;
            recipe.getIngredients().add(ir.findByName(finalIngredient.getName()));
            rr.save(recipe);
        }else{
            throw new Existe("Ya existe un ingrediente con ese nombre");
        }
        return findIngredient(ir.findByName(ingredient.name()).getId());
    }
}
