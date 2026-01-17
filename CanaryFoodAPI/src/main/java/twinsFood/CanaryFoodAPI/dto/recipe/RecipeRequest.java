package twinsFood.CanaryFoodAPI.dto.recipe;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.ArrayList;

public record RecipeRequest(int id,
                            @NotNull(message = "Este campo es obligatorio") @NotBlank(message = "Este campo no puede estar vacío")
                            String title,
                            @NotNull(message = "Este campo es obligatorio") @NotBlank(message = "Este campo no puede estar vacío")
                            String type,
                            ArrayList<Integer> ingredients,
                            @NotNull(message = "Este campo es obligatorio") @NotBlank(message = "Este campo no puede estar vacío")
                            String steps,
                            String picture,
                            ArrayList<Integer> reviews){}
