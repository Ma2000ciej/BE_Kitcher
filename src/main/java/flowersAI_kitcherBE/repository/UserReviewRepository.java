package flowersAI_kitcherBE.repository;

import flowersAI_kitcherBE.entity.RecipeReview;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserReviewRepository extends JpaRepository<RecipeReview, Integer> {
}
