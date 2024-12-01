package flower.ai.kitcherBE.entity;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.core.annotation.Order;

import java.util.List;

@EntityScan
public class Recipe extends DataBaseItem {
    private List<FoodItems> foodItems;
    private List<Integer> order;
    private String description;


}
