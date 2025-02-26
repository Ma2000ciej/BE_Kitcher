package flowersAI_kitcherBE.dto;

import flowersAI_kitcherBE.entity.FoodItem;
import flowersAI_kitcherBE.entity.Recipe;

import java.util.List;

public class RecipeDTO {
    private  long id;
    private  List<FoodItem> ingredientList;
    private  String name;
    private  String description;
    private  long authorId;
    private  float rating;

    public double getCalories() {
        return calories;
    }

    public void setCalories(double calories) {
        this.calories = calories;
    }

    private double calories;

    public  RecipeDTO (Recipe recipe){
        this.id=recipe.getId();
        this.ingredientList = recipe.getIngredients();
        this.name = recipe.getName();
        this.description= recipe.getDescription();
        this.authorId=recipe.getCreated_by();
    }

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<FoodItem> getIngredientList() {
        return ingredientList;
    }

    public void setIngredientList(List<FoodItem> ingredientList) {
        this.ingredientList = ingredientList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }
}
