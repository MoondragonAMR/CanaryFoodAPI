package twinsFood.CanaryFoodAPI.interfaces;

import twinsFood.CanaryFoodAPI.dtos.recipe.Filters;
import twinsFood.CanaryFoodAPI.dtos.recipe.RecipeRequest;
import twinsFood.CanaryFoodAPI.dtos.recipe.RecipeResponse;
import twinsFood.CanaryFoodAPI.exceptions.Existe;
import twinsFood.CanaryFoodAPI.exceptions.NoExiste;
import twinsFood.CanaryFoodAPI.exceptions.NoTuya;

import java.util.List;

public interface IRecipeService {

    public List<RecipeResponse> getRecipes(Filters filters);

    public RecipeResponse findRecipe(int id) throws NoExiste;

    public RecipeResponse addRecipe(RecipeRequest recipe, String user) throws Existe;

    public RecipeResponse updateRecipe(RecipeRequest recipe, int id, String user) throws Existe, NoExiste, NoTuya;

    public void deleteRecipe(int id, String user) throws NoExiste, NoTuya;

}
