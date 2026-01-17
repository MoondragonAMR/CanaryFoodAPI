package twinsFood.CanaryFoodAPI.dto.ingredient;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.ArrayList;

public record IngredientRequest(int id,
                                @NotNull(message = "Este campo es obligatorio") @NotBlank(message = "Este campo no puede estar vacío")
                                String name,
                                @NotNull(message = "Este campo es obligatorio") @NotBlank(message = "Este campo no puede estar vacío")
                                String type,
                                @NotNull(message = "Este campo es obligatorio") @NotBlank(message = "Este campo no puede estar vacío")
                                boolean vegetarian,
                                @NotNull(message = "Este campo es obligatorio") @NotBlank(message = "Este campo no puede estar vacío")
                                boolean vegan,
                                @NotNull(message = "Este campo es obligatorio") @NotBlank(message = "Este campo no puede estar vacío")
                                boolean sugar,
                                @NotNull(message = "Este campo es obligatorio") @NotBlank(message = "Este campo no puede estar vacío")
                                boolean gluten,
                                @NotNull(message = "Este campo es obligatorio") @NotBlank(message = "Este campo no puede estar vacío")
                                boolean dairy,
                                String picture,
                                ArrayList<Integer> recipes){}
