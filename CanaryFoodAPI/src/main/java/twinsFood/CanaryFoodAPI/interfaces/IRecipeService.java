package twinsFood.CanaryFoodAPI.interfaces;

import twinsFood.CanaryFoodAPI.dto.recipe.Filters;
import twinsFood.CanaryFoodAPI.dto.recipe.RecipeRequest;
import twinsFood.CanaryFoodAPI.dto.recipe.RecipeResponse;
import twinsFood.CanaryFoodAPI.exceptions.Existe;
import twinsFood.CanaryFoodAPI.exceptions.NoExiste;
import twinsFood.CanaryFoodAPI.models.Ingredient;

import java.util.ArrayList;
import java.util.List;

public interface IRecipeService {

    public List<RecipeResponse> getRecipes(Filters filters);

    public RecipeResponse findRecipe(int id) throws NoExiste;

    public RecipeResponse addRecipe(RecipeRequest recipe) throws Existe;

    public RecipeResponse updateRecipe(RecipeRequest recipe, int id) throws Existe, NoExiste;

    public void deleteRecipe(int id) throws NoExiste;

}
