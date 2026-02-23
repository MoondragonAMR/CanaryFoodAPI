package twinsFood.CanaryFoodAPI.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(unique = true)
    @NotNull(message = "Este campo es obligatorio")
    @NotBlank(message = "Este campo no puede estar en blanco")
    @Size(min = 10, max = 10, message = "El dni ha de tener 10 caracteres")
    @Pattern(regexp = "^\\d{9}[A-Z]+$", message = "El dni ha de contener 9 dígitos y una letra mayúscula")
    private String dni;
    @Column(unique = true)
    @NotNull(message = "Este campo es obligatorio")
    @NotBlank(message = "Este campo no puede estar en blanco")
    @Email(message = "El email ha de contener un @")
    private String email;
    @NotNull(message = "Este campo es obligatorio")
    @NotBlank(message = "Este campo no puede estar en blanco")
    @Size(min = 10, max = 50, message = "El nombre completo ha de tener entre 10 y 50 caracteres")
    private String nombreCompleto;
    @Pattern(regexp = "^\\d+$", message = "El teléfono ha de contener solo dígitos")
    @Size(min = 9, max = 9, message = "El teléfono ha de tener 9 dígitos")
    private String tlf;
    @NotNull(message = "Este campo es obligatorio")
    @NotBlank(message = "Este campo no puede estar en blanco")
    @Size(min = 5, message = "La contraseña ha de tener al menos 5 caracteres")
    private String password;

    @ManyToMany(cascade = { CascadeType.MERGE }, fetch = FetchType.EAGER)
    @JoinTable(
            name = "UserRole",
            joinColumns = { @JoinColumn(name = "user_id")},
            inverseJoinColumns = { @JoinColumn(name = "role_id")}
    )
    private List<Role> roles = new ArrayList<>();

    public User() {
    }

    public User(String dni, String email, String nombreCompleto, String tlf, String password, Role role) {
        this.dni = dni;
        this.email = email;
        this.nombreCompleto = nombreCompleto;
        this.tlf = tlf;
        this.password = password;
        this.roles.add(role);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getTlf() {
        return tlf;
    }

    public void setTlf(String tlf) {
        this.tlf = tlf;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }
}
