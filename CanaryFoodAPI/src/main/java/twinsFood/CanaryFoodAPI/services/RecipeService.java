package twinsFood.CanaryFoodAPI.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import twinsFood.CanaryFoodAPI.dtos.recipe.*;
import twinsFood.CanaryFoodAPI.exceptions.Existe;
import twinsFood.CanaryFoodAPI.exceptions.NoExiste;
import twinsFood.CanaryFoodAPI.exceptions.NoTuya;
import twinsFood.CanaryFoodAPI.interfaces.IRecipeService;
import twinsFood.CanaryFoodAPI.models.Recipe;
import twinsFood.CanaryFoodAPI.repositories.RecipeRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class RecipeService implements IRecipeService {

    @Autowired
    private RecipeRepository rr;

    @Override
    public List<RecipeResponse> getRecipes(Filters filters) {
        List<Recipe> recipes = rr.findAll();
        List<RecipeResponse> recipesResponse = new ArrayList<>();
        recipes.forEach(recipe -> {
            if (filters.type() == null || recipe.getType().matches(filters.type())) {
                ArrayList<IngredientInRecipeResponse> ingredients = new ArrayList<>();
                final boolean[] mostrar = {true};
                final boolean[] contiene = {false};
                recipe.getIngredients().forEach(ingredient -> {
                    if (filters.withoutIngredients().contains(ingredient)) {
                        mostrar[0] = false;
                    }
                    if (filters.withIngredients().isEmpty() || filters.withIngredients().contains(ingredient)) {
                        contiene[0] = true;
                    }
                    ArrayList<Integer> recipesIngredient = new ArrayList<>();
                    ingredient.getRecipes().forEach(recipeingredient -> {
                        recipesIngredient.add(recipeingredient.getId());
                    });
                    ingredients.add(new IngredientInRecipeResponse(ingredient.getId(), ingredient.getName(),
                            ingredient.getType(), recipesIngredient));
                });
                if (mostrar[0] && contiene[0]) {
                    ArrayList<ReviewInRecipeResponse> reviews = new ArrayList<>();
                    recipe.getReviews().forEach(review -> {
                        int recipeReview = review.getRecipe().getId();
                        reviews.add(new ReviewInRecipeResponse(review.getId(), review.getTitle(),
                                review.getDescription(), review.getRating(), review.getAuthor(),
                                recipeReview));
                    });
                    recipesResponse.add(new RecipeResponse(recipe.getId(), recipe.getTitle(), recipe.getType(), ingredients,
                            recipe.getSteps(), recipe.getPicture(), reviews, recipe.getAuthor()));
                }
            }
        });
        return recipesResponse;
    }

    @Override
    public RecipeResponse findRecipe(int id) throws NoExiste {
        Recipe recipe = rr.findById(id).orElse(null);
        if (recipe == null) throw new NoExiste("No existe ninguna receta con ese id");
        ArrayList<IngredientInRecipeResponse> ingredients = new ArrayList<>();
        recipe.getIngredients().forEach(ingredient -> {
            ArrayList<Integer> recipesIngredient = new ArrayList<>();
            ingredient.getRecipes().forEach(recipeingredient -> {
                recipesIngredient.add(recipeingredient.getId());
            });
            ingredients.add(new IngredientInRecipeResponse(ingredient.getId(), ingredient.getName(),
                    ingredient.getType(), recipesIngredient));
        });
        ArrayList<ReviewInRecipeResponse> reviews = new ArrayList<>();
        recipe.getReviews().forEach(review -> {
            int recipeReview = review.getRecipe().getId();
            reviews.add(new ReviewInRecipeResponse(review.getId(), review.getTitle(),
                    review.getDescription(), review.getRating(), review.getAuthor(),
                    recipeReview));
        });
        return new RecipeResponse(recipe.getId(), recipe.getTitle(), recipe.getType(), ingredients,
                recipe.getSteps(), recipe.getPicture(), reviews, recipe.getAuthor());
    }

    @Override
    public RecipeResponse addRecipe(RecipeRequest recipe, String user) throws Existe {
        final boolean[] correcto = {true};
        rr.findAll().forEach(encontrado -> {
            if (encontrado.getTitle().matches(recipe.title())){
                correcto[0] = false;
            }
        });
        if (correcto[0]) {
            Recipe finalRecipe = new Recipe(recipe.title(), recipe.type(), recipe.steps(), recipe.picture());
            finalRecipe.setAuthor(user);
            rr.save(finalRecipe);
        }else{
            throw new Existe("Ya existe una receta con ese título");
        }
        return findRecipe(rr.findByTitle(recipe.title()).getId());
    }

    @Override
    public RecipeResponse updateRecipe(RecipeRequest recipe, int id, String user) throws Existe, NoExiste, NoTuya {
        if (findRecipe(id) == null) throw new NoExiste("No existe ninguna receta con ese id");
        Recipe finalRecipe = rr.findById(id).orElse(null);
        assert finalRecipe != null;
        if (!finalRecipe.getAuthor().matches(user)) {
            throw new NoTuya("No puedes editar una receta que no es tuya");
        }
        finalRecipe.setTitle(recipe.title());
        finalRecipe.setType(recipe.type());
        finalRecipe.setSteps(recipe.steps());
        finalRecipe.setPicture(recipe.picture());
        finalRecipe.setId(id);
        final boolean[] correcto = {true};
        rr.findAll().forEach(encontrado -> {
            if ((encontrado.getTitle().matches(recipe.title()))
                    && !(encontrado.getId() == id)) {
                correcto[0] = false;
            }
        });
        if (correcto[0]) {
            rr.save(finalRecipe);
        }else{
            throw new Existe("Ya existe una receta con ese título");
        }
        return findRecipe(id);
    }

    @Override
    public void deleteRecipe(int id, String user) throws NoExiste, NoTuya {
        RecipeResponse recipe = findRecipe(id);
        if (recipe == null) {
            throw new NoExiste("No existe ninguna receta con ese id");
        } else if (!recipe.author().matches(user)) {
            throw new NoTuya("No puedes eliminar una receta que no es tuya");
        } else rr.deleteById(id);
    }
}
