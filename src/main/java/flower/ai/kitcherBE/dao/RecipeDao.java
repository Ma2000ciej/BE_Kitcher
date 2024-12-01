package flower.ai.kitcherBE.dao;

import flower.ai.kitcherBE.entity.FoodItems;
import flower.ai.kitcherBE.entity.Recipe;
import jdk.jshell.spi.ExecutionControl;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.List;

public class RecipeDao {

    private final JdbcTemplate jdbcTemplate;

    public RecipeDao(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Recipe> getRecipesByFoodItems (List<FoodItems> foodItems) {

        List<Recipe> test = new ArrayList<>();
        return test;
    }


}
