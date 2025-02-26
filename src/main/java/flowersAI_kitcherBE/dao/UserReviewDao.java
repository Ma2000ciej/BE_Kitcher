package flowersAI_kitcherBE.dao;

import flowersAI_kitcherBE.entity.RecipeReview;
import flowersAI_kitcherBE.repository.UserReviewRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserReviewDao {
    private final JdbcTemplate jdbcTemplate;
    private final UserReviewRepository userReviewRepository;

    public UserReviewDao(JdbcTemplate jdbcTemplate,UserReviewRepository userReviewRepository){
        this.jdbcTemplate = jdbcTemplate;
        this.userReviewRepository=userReviewRepository;
    }

    public Boolean rateRecipe(RecipeReview userReview){
        this.userReviewRepository.save(userReview);
        return Boolean.TRUE;
    }
}
