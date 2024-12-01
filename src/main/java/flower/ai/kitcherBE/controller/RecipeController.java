package flower.ai.kitcherBE.controller;

import flower.ai.kitcherBE.entity.FoodItems;
import flower.ai.kitcherBE.entity.Recipe;
import flower.ai.kitcherBE.service.RecipeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RecipeController {

    private final RecipeService recipeService;


    public RecipeController(RecipeService recipeService) {
        this.recipeService= recipeService;
    }


    @GetMapping("/RecipeFromFood")
    public List<Recipe> getRecipesByFoodItems(@RequestParam Integer userId) {

        return this.recipeService.getRecipesByUserFoodItem(userId);

    }
}
