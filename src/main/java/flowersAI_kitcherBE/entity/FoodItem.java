package flowersAI_kitcherBE.entity;

import jakarta.persistence.*;

import javax.xml.crypto.Data;

@Entity
public class FoodItem {
    @Id
    private long id;
    private String name;
    private String timeToExpire;
    @Column
    private double calories;
    @ManyToOne
    @JoinColumn(name = "fridge_id", nullable = false)
    private Fridge fridge;
    @ManyToOne
    @JoinColumn(name = "recipe_id", nullable = false)
    private Recipe recipe;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTimeToExpire() {
        return timeToExpire;
    }

    public void setTimeToExpire(String timeToExpire) {
        this.timeToExpire = timeToExpire;
    }

    public double getCalories() {
        return calories;
    }

    public void setCalories(double calories) {
        this.calories = calories;
    }

    public Fridge getFridge() {
        return fridge;
    }

    public void setFridge(Fridge fridge) {
        this.fridge = fridge;
    }

    public Recipe getRecipe() {
        return recipe;
    }

    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }
}
