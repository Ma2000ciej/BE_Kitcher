package flowersAI_kitcherBE.controller;

import flowersAI_kitcherBE.dto.RecipeDTO;
import flowersAI_kitcherBE.dto.RecipeReviewDTO;
import flowersAI_kitcherBE.entity.Recipe;
import flowersAI_kitcherBE.entity.RecipeReview;
import flowersAI_kitcherBE.service.RecipeReviewService;
import flowersAI_kitcherBE.service.RecipeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/recipes")
public class RecipeController {

    private final RecipeService recipeService;
    ///NIE WIEM CZY NIE WYCIAGNAC TEGO DO OSOBNEGO KONTROLERA
    private final RecipeReviewService recipeReviewService;

    public RecipeController(RecipeService recipeService,RecipeReviewService recipeReviewService) {
        this.recipeReviewService= recipeReviewService;
        this.recipeService= recipeService;
    }


    @GetMapping("/AddRecipe")
    public Boolean addRecipe(@RequestParam RecipeDTO recipeDTO){
        return this.recipeService.addRecipe(recipeDTO);
    }
    @PostMapping("/RemoveRecipe")
    public Boolean removeRecipe(@RequestParam RecipeDTO recipeDTO){
        return this.recipeService.removeRecipe(recipeDTO);
    }
    @PostMapping("/EditRecipe")
    public RecipeDTO editRecipe(@RequestParam RecipeDTO recipeDTO){
        return this.recipeService.editRecipe(recipeDTO);
    }
    @PostMapping("/RateRecipe")
    public Boolean rateRecipe(@RequestParam RecipeReviewDTO recipeReviewDTO){
        return this.recipeReviewService.rateRecipe(recipeReviewDTO);
    }

    @GetMapping("/RecipeFromFood")
    public List<RecipeDTO> getRecipesByFoodItems(@RequestParam Integer userId) {

        return this.recipeService.getRecipesByUserFoodItem(userId);
    }
}
