package twinsFood.CanaryFoodAPI.dtos.recipe;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record RecipeRequest(@NotNull(message = "Este campo es obligatorio") @NotBlank(message = "Este campo no puede estar vacío")
                            String title,
                            @NotNull(message = "Este campo es obligatorio") @NotBlank(message = "Este campo no puede estar vacío")
                            String type,
                            @NotNull(message = "Este campo es obligatorio") @NotBlank(message = "Este campo no puede estar vacío")
                            String steps,
                            String picture){}
