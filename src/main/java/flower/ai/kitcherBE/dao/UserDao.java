package flower.ai.kitcherBE.dao;

import flower.ai.kitcherBE.entity.FoodItems;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.List;

public class UserDao {

    private final JdbcTemplate jdbcTemplate;

    public UserDao(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<FoodItems> getUserFoodInStore(Integer userId){
        List<FoodItems> dupa = new ArrayList<FoodItems>();
        ///Zapytanie Do bazy
        return dupa;

    }






}
