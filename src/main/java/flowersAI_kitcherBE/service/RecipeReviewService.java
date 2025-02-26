package flowersAI_kitcherBE.service;

import flowersAI_kitcherBE.dao.UserReviewDao;
import flowersAI_kitcherBE.dto.RecipeReviewDTO;
import flowersAI_kitcherBE.entity.RecipeReview;

public class RecipeReviewService {
    private  final UserReviewDao userReviewDao;

    public RecipeReviewService(UserReviewDao userReviewDao){
        this.userReviewDao = userReviewDao;
    }
    public Boolean rateRecipe(RecipeReviewDTO recipeReviewDTO){
        RecipeReview recipeReview = new RecipeReview(recipeReviewDTO);
        this.userReviewDao.rateRecipe(recipeReview);
        return Boolean.TRUE;
    }
}
