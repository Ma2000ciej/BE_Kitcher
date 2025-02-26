package flowersAI_kitcherBE.repository;

import flowersAI_kitcherBE.entity.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecipeRepository  extends JpaRepository<Recipe, Long>{



}
