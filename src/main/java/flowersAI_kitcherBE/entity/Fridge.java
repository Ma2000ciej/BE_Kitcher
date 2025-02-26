package flowersAI_kitcherBE.entity;

import flowersAI_kitcherBE.dto.FridgeDTO;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Fridge {

    @Id
    private long Id;

    @Column
    private String name;
    @OneToMany(mappedBy = "fridge", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<FoodItem> foodItemInFridge;

    public long getId() {
        return Id;
    }

    public void setId(long id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public Fridge(){};
    public Fridge(FridgeDTO fridge){
        this.name=fridge.getName();
    }
    public List<FoodItem> getFoodItemInFridge() {
        return foodItemInFridge;
    }

    public void setFoodItemInFridge(List<FoodItem> foodItemInFridge) {
        this.foodItemInFridge = foodItemInFridge;
    }
}
