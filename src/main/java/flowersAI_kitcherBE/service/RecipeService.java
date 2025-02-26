package flowersAI_kitcherBE.service;

import flowersAI_kitcherBE.dao.RecipeDao;
import flowersAI_kitcherBE.dto.RecipeDTO;
import flowersAI_kitcherBE.entity.FoodItem;
import flowersAI_kitcherBE.entity.Recipe;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RecipeService {

    private final RecipeDao recipeDao;
    private final UserService userService;

    public RecipeService(RecipeDao recipeDao, UserService userService){
        this.recipeDao = recipeDao;
        this.userService = userService;
    }
    public double calculateCalories(List<FoodItem> ingredients){
        double calories = 0;
        for (FoodItem ingredient: ingredients){
            calories = calories + ingredient.getCalories();
        }
        return calories;
    }
    public List<RecipeDTO> getRecipesByUserFoodItem(Integer userId) {
        /// Pobieramy jedzenie od typa
        List<FoodItem> foodItems = null;// this.userService.getUserFoodInStore(userId);
        /// Czy tylko pasujace czy nie?
        return  this.recipeDao.getRecipesByFoodItems( foodItems);
    }
    public Boolean addRecipe(RecipeDTO recipeDTO){
        if(recipeDTO.getCalories() == 0 ){
            recipeDTO.setCalories(calculateCalories(recipeDTO.getIngredientList()));

        }
        Recipe recipeToAdd = new Recipe(recipeDTO);
        if(this.recipeDao.checkIfThereIsRecipe(recipeToAdd)){
            /// Wymaga przemyslenia
            return null;
        }

        return this.recipeDao.addRecipe(recipeToAdd);
    }


    public Boolean removeRecipe(RecipeDTO recipeDTO){
        Recipe recipeToRemove =  new Recipe(recipeDTO);
        return  this.recipeDao.removeRecipe(recipeToRemove);
    }
    public RecipeDTO editRecipe(RecipeDTO recipeDTO){
        Recipe recipeToEdit =  new Recipe(recipeDTO);
        return new RecipeDTO(this.recipeDao.editRecipe(recipeToEdit));

    }


}
