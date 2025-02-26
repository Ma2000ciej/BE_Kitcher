package flowersAI_kitcherBE.entity;

import flowersAI_kitcherBE.dto.RecipeDTO;
import jakarta.persistence.*;

import java.sql.Timestamp;
import java.util.List;

@Entity
public class Recipe {
    @Id
    private long Id;



    @OneToMany(mappedBy = "recipe", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<FoodItem> ingredients;
    @Column
    private List<Integer> order;
    @Column
    private String name;
    @Column
    private Timestamp created_at;
    @Column
    private Timestamp updated_at;
    @Column
    private long created_by;
    @Column
    private String description;
    public Recipe (RecipeDTO recipeDTO){
        this.name=recipeDTO.getName();
        this.created_by=recipeDTO.getAuthorId();
        this.ingredients=recipeDTO.getIngredientList();
        this.description= recipeDTO.getDescription();
    }

    public long getId() {
        return Id;
    }

    public void setId(long id) {
        Id = id;
    }

    public List<FoodItem> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<FoodItem> ingredients) {
        this.ingredients = ingredients;
    }

    public List<Integer> getOrder() {
        return order;
    }

    public void setOrder(List<Integer> order) {
        this.order = order;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Timestamp getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Timestamp created_at) {
        this.created_at = created_at;
    }

    public Timestamp getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(Timestamp updated_at) {
        this.updated_at = updated_at;
    }

    public long getCreated_by() {
        return created_by;
    }

    public void setCreated_by(long created_by) {
        this.created_by = created_by;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
