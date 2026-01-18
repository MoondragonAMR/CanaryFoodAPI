package twinsFood.CanaryFoodAPI.dto.recipe;

import twinsFood.CanaryFoodAPI.models.Ingredient;

import java.util.ArrayList;

public record Filters(String type,
                      ArrayList<Ingredient> withIngredients,
                      ArrayList<Ingredient> withoutIngredients) { }
