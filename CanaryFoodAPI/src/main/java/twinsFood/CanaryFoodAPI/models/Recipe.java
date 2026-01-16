package twinsFood.CanaryFoodAPI.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull(message = "Este campo es obligatorio") @NotBlank(message = "Este campo no puede estar vacío")
    private String title;

    @NotNull(message = "Este campo es obligatorio") @NotBlank(message = "Este campo no puede estar vacío")
    private String type;

    @ManyToMany(cascade = CascadeType.MERGE)
    @JoinTable(name="recipe_ingredient")
    private List<Ingredient> ingredients = new ArrayList<>();

    @NotNull(message = "Este campo es obligatorio") @NotBlank(message = "Este campo no puede estar vacío")
    private String steps;

    private String picture;

    @OneToMany(mappedBy = "recipe")
    private List<Review> reviews = new ArrayList<>();

    public Recipe() {
    }

    public Recipe(int id, String title, String type, String steps, String picture) {
        this.id = id;
        this.title = title;
        this.type = type;
        this.steps = steps;
        this.picture = picture;
    }

    public Recipe(String title, String type, String steps, String picture) {
        this.title = title;
        this.type = type;
        this.steps = steps;
        this.picture = picture;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }


    public String getSteps() {
        return steps;
    }

    public void setSteps(String steps) {
        this.steps = steps;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public List<Review> getReviews() {
        return reviews;
    }
}
