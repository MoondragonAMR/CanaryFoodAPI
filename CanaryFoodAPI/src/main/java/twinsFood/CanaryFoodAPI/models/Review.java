package twinsFood.CanaryFoodAPI.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull(message = "Este campo es obligatorio") @NotBlank(message = "Este campo no puede estar vacío")
    private String title;

    @NotNull(message = "Este campo es obligatorio") @NotBlank(message = "Este campo no puede estar vacío")
    private String description;

    @Min(value = 0, message = "No puede haber valoración negativa") @Max(value = 5, message = "La valoración deber ser máximo 5")
    private double rating;

    private String author;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name="recipe_id", referencedColumnName = "id")
    private Recipe recipe;

    public Review() {
    }

    public Review(int id, String title, String description, double rating, String author, Recipe recipe) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.rating = rating;
        this.author = author;
        this.recipe = recipe;
    }

    public Review(int id, String title, String description, double rating, Recipe recipe) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.rating = rating;
        this.recipe = recipe;
    }

    public Review(String title, String description, double rating, String author, Recipe recipe) {
        this.title = title;
        this.description = description;
        this.rating = rating;
        this.author = author;
        this.recipe = recipe;
    }

    public Review(String title, String description, double rating, Recipe recipe) {
        this.title = title;
        this.description = description;
        this.rating = rating;
        this.recipe = recipe;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Recipe getRecipe() {
        return recipe;
    }

    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }
}
