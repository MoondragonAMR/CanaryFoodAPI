package twinsFood.CanaryFoodAPI.dtos.ingredient;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record IngredientRequest(@NotNull(message = "Este campo es obligatorio") @NotBlank(message = "Este campo no puede estar vacío")
                                String name,
                                @NotNull(message = "Este campo es obligatorio") @NotBlank(message = "Este campo no puede estar vacío")
                                String type,
                                boolean vegetarian,
                                boolean vegan,
                                boolean sugar,
                                boolean gluten,
                                boolean dairy,
                                String picture,
                                int recipe){}
