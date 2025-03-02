package flowersAI_kitcherBE.repository;

import flowersAI_kitcherBE.entity.FoodItem;
import flowersAI_kitcherBE.entity.Fridge;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FridgeRepository  extends JpaRepository<Fridge, Integer>{

    @Modifying
    @Query("UPDATE Fridge f SET f.name = :newName WHERE f.id = :fridgeId")
    void updateFridgeName(@Param("fridgeId") int fridgeId, @Param("newName") String newName);
    @Query("SELECT f FROM Fridge f WHERE f.user.id = :userId")
    List<Fridge> getFridgesForUser(@Param("userId") long userId);
    ///TODO ZMIANA
   /* @Modifying
    @Query("Select fi From fridge_items fi where fridge_id =: fridgeId AND expiry_date BETWEEN GETDATE() and DATE_ADD(CURRENT_DATE, INTERVAL + 3 DAY))")
    List<FoodItem> getSoonExpireFood(@Param("fridgeId") long fridgeId);
   */


}
