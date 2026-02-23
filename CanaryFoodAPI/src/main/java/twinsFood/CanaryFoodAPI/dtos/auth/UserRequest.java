package twinsFood.CanaryFoodAPI.dtos.auth;

import jakarta.persistence.Column;
import jakarta.validation.constraints.*;

public record UserRequest(@Column(unique = true)
                          @NotNull(message = "Este campo es obligatorio")
                          @NotBlank(message = "Este campo no puede estar en blanco")
                          @Size(min = 10, max = 10, message = "El dni ha de tener 10 caracteres")
                          @Pattern(regexp = "^\\d{9}[A-Z]+$", message = "El dni ha de contener 9 dígitos y una letra mayúscula")
                          String dni,
                          @Column(unique = true)
                          @NotNull(message = "Este campo es obligatorio")
                          @NotBlank(message = "Este campo no puede estar en blanco")
                          @Email(message = "El email ha de contener un @")
                          String email,
                          @NotNull(message = "Este campo es obligatorio")
                          @NotBlank(message = "Este campo no puede estar en blanco")
                          @Size(min = 10, max = 50, message = "El nombre completo ha de tener entre 10 y 50 caracteres")
                          String nombreCompleto,
                          @Pattern(regexp = "^\\d+$", message = "El teléfono ha de contener solo dígitos")
                          @Size(min = 9, max = 9, message = "El teléfono ha de tener 9 dígitos")
                          String tlf,
                          @NotNull(message = "Este campo es obligatorio")
                          @NotBlank(message = "Este campo no puede estar en blanco")
                          @Size(min = 5, message = "La contraseña ha de tener al menos 5 caracteres")
                          String password) { }