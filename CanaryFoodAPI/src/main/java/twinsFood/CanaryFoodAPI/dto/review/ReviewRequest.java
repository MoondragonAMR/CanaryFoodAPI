package twinsFood.CanaryFoodAPI.dto.review;

import jakarta.persistence.CascadeType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ReviewRequest(int id,
                            @NotNull(message = "Este campo es obligatorio") @NotBlank(message = "Este campo no puede estar vacío")
                            String title,
                            @NotNull(message = "Este campo es obligatorio") @NotBlank(message = "Este campo no puede estar vacío")
                            String description,
                            @NotNull(message = "Este campo es obligatorio") @NotBlank(message = "Este campo no puede estar vacío")
                            @Min(value = 0, message = "No puede haber valoración negativa") @Max(value = 5, message = "La valoración deber ser máximo 5")
                            double rating,
                            String author,
                            int recipe){}
