package twinsFood.CanaryFoodAPI.interfaces;

import twinsFood.CanaryFoodAPI.dtos.ingredient.IngredientRequest;
import twinsFood.CanaryFoodAPI.dtos.ingredient.IngredientResponse;
import twinsFood.CanaryFoodAPI.exceptions.Existe;
import twinsFood.CanaryFoodAPI.exceptions.NoExiste;

import java.util.List;

public interface IIngredientService {

    public List<IngredientResponse> getIngredients();

    List<IngredientResponse> filterIngredients(int id);

    public IngredientResponse findIngredient(int id) throws NoExiste;
    public IngredientResponse addIngredient(IngredientRequest ingredient) throws Existe;

}
