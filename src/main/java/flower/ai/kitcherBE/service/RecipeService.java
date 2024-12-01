package flower.ai.kitcherBE.service;

import flower.ai.kitcherBE.dao.RecipeDao;
import flower.ai.kitcherBE.entity.FoodItems;
import flower.ai.kitcherBE.entity.Recipe;

import java.util.List;

public class RecipeService {

    private final RecipeDao recipeDao;
    private final UserService userService;
    public  RecipeService(RecipeDao recipeDao, UserService userService){
        this.recipeDao = recipeDao;
        this.userService = userService;
    }

    public List<Recipe> getRecipesByUserFoodItem( Integer userId) {

        /// Pobieramy jedzenie od typa
        List<FoodItems> foodItems = this.userService.getUserFoodInStore(userId);
        /// Czy tylko pasujace czy nie?

        return  this.recipeDao.getRecipesByFoodItems( foodItems);
    }

}
