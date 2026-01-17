package twinsFood.CanaryFoodAPI.interfaces;

import twinsFood.CanaryFoodAPI.dto.ingredient.IngredientRequest;
import twinsFood.CanaryFoodAPI.dto.ingredient.IngredientResponse;
import twinsFood.CanaryFoodAPI.exceptions.Existe;

import java.util.List;

public interface IIngredientService {

    public List<IngredientResponse> getIngredients();
    public IngredientResponse addIngredient(IngredientRequest ingredient) throws Existe;

}
