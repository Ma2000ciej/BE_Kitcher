package flowersAI_kitcherBE.dao;

import flowersAI_kitcherBE.dto.RecipeDTO;
import flowersAI_kitcherBE.entity.FoodItem;
import flowersAI_kitcherBE.entity.Recipe;
import flowersAI_kitcherBE.repository.RecipeRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
public class RecipeDao {

    private final JdbcTemplate jdbcTemplate;
    private final RecipeRepository recipeRepository;

    public RecipeDao(JdbcTemplate jdbcTemplate, RecipeRepository recipeRepository){

        this.jdbcTemplate = jdbcTemplate;
        this.recipeRepository=recipeRepository;
    }
    public Boolean checkIfThereIsRecipe(Recipe recipe){
        /// Kurna nie wiem jeszcze jak to ogarnac
        return false;
    }

    public List<RecipeDTO> getRecipesByFoodItems (List<FoodItem> foodItems) {

        List<RecipeDTO> test = new ArrayList<>();
        return test;
    }
    public Boolean addRecipe(Recipe recipe){
        try {
            this.recipeRepository.save(recipe);
            return Boolean.TRUE;
        }catch (Exception e){
            return Boolean.FALSE;
        }

    }
    public Recipe editRecipe(Recipe recipe){

        try {
            Recipe recipeToEdit = this.recipeRepository.findById(recipe.getId())
                    .orElse(null);
            if(recipeToEdit == null){
                ///Log.CANT.FIND.SHIT
                return recipe;
            }
            recipeToEdit.setDescription(recipe.getDescription());
            //recipeToEdit.setOrder(recipe.getOrder());
            //recipeToEdit.setIngredients(recipe.getIngredients());
            this.recipeRepository.save(recipeToEdit);
            return recipeToEdit;
        }catch (Exception e ){
            return recipe;
        }
    }
    public Boolean removeRecipe(Recipe recipe){

        try {
            if(this.recipeRepository.existsById(recipe.getId())){
                this.recipeRepository.deleteById(recipe.getId());
                return Boolean.TRUE;
            }
            return Boolean.FALSE;
        } catch (Exception e) {
            ///loga
            return Boolean.FALSE;
        }
    }



}
