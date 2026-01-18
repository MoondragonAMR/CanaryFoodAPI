package twinsFood.CanaryFoodAPI.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Ingredient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull(message = "Este campo es obligatorio") @NotBlank(message = "Este campo no puede estar vacío")
    private String name;

    @NotNull(message = "Este campo es obligatorio") @NotBlank(message = "Este campo no puede estar vacío")
    private String type;

    private boolean vegetarian;

    private boolean vegan;

    private boolean sugar;

    private boolean gluten;

    private boolean dairy;

    private String picture;

    @ManyToMany(mappedBy = "ingredients", fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    private List<Recipe> recipes = new ArrayList<>();

    public Ingredient() {
    }

    public Ingredient(int id, String name, String type, boolean vegetarian, boolean vegan, boolean sugar, boolean gluten, boolean dairy, String picture) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.vegetarian = vegetarian;
        this.vegan = vegan;
        this.sugar = sugar;
        this.gluten = gluten;
        this.dairy = dairy;
        this.picture = picture;
    }

    public Ingredient(String name, String type, boolean vegetarian, boolean vegan, boolean sugar, boolean gluten, boolean dairy, String picture) {
        this.name = name;
        this.type = type;
        this.vegetarian = vegetarian;
        this.vegan = vegan;
        this.sugar = sugar;
        this.gluten = gluten;
        this.dairy = dairy;
        this.picture = picture;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean isVegetarian() {
        return vegetarian;
    }

    public void setVegetarian(boolean vegetarian) {
        this.vegetarian = vegetarian;
    }

    public boolean isVegan() {
        return vegan;
    }

    public void setVegan(boolean vegan) {
        this.vegan = vegan;
    }

    public boolean isSugar() {
        return sugar;
    }

    public void setSugar(boolean sugar) {
        this.sugar = sugar;
    }

    public boolean isGluten() {
        return gluten;
    }

    public void setGluten(boolean gluten) {
        this.gluten = gluten;
    }

    public boolean isDairy() {
        return dairy;
    }

    public void setDairy(boolean dairy) {
        this.dairy = dairy;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public List<Recipe> getRecipes() {
        return recipes;
    }
}
