package twinsFood.CanaryFoodAPI.interfaces;

import twinsFood.CanaryFoodAPI.dto.ingredient.IngredientRequest;
import twinsFood.CanaryFoodAPI.dto.ingredient.IngredientResponse;
import twinsFood.CanaryFoodAPI.exceptions.Existe;
import twinsFood.CanaryFoodAPI.exceptions.NoExiste;

import java.util.List;

public interface IIngredientService {

    public List<IngredientResponse> getIngredients();
    public IngredientResponse findIngredient(int id) throws NoExiste;
    public IngredientResponse addIngredient(IngredientRequest ingredient) throws Existe;

}
