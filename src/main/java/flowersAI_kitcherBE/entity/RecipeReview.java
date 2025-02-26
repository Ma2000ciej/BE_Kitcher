package flowersAI_kitcherBE.entity;

import flowersAI_kitcherBE.dto.RecipeDTO;
import flowersAI_kitcherBE.dto.RecipeReviewDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.sql.Timestamp;

@Entity
public class RecipeReview {
    @Id
    private long id;
    private long userId;
    private  long recipeId;
    private double rating;
    private String comment;
    private Timestamp create_at;

    public RecipeReview(RecipeReviewDTO recipeReviewDTO) {
        this.id = recipeReviewDTO.getId();
        this.userId = recipeReviewDTO.getUserId();
        this.recipeId = recipeReviewDTO.getRecipeId();
        this.rating = recipeReviewDTO.getRating();
        this.comment = recipeReviewDTO.getComment();
        this.create_at = recipeReviewDTO.getCreate_at();
    }





}
