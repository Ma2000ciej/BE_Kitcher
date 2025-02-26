package flowersAI_kitcherBE.dao;

import flowersAI_kitcherBE.entity.FoodItem;
import flowersAI_kitcherBE.entity.Fridge;
import flowersAI_kitcherBE.entity.Recipe;
import flowersAI_kitcherBE.entity.User;
import flowersAI_kitcherBE.repository.FridgeRepository;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/// DONE Lista Jedzenia z lodówki, Dodanie jedzenia do lodówki dodanie wielu produktów do lodówki
/// usnięcie z lodówki  Usiniecie wielu produków z lodówki
/// Ustawienie nazwy lodówki
/// Dodanie usuniecie lodówki
///
@Repository
public class FridgeDao {

    private final JdbcTemplate jdbcTemplate;
    private final FridgeRepository fridgeRepository;

    public FridgeDao(JdbcTemplate jdbcTemplate,FridgeRepository fridgeRepository){

        this.jdbcTemplate = jdbcTemplate;
        this.fridgeRepository =fridgeRepository;
    }


    public List<FoodItem> getUserCloseToExpireProducts(User user){
        List<Fridge> listOfFridges = this.getUserFridges(user);
        List<FoodItem> listOfFoodItems = new ArrayList<FoodItem>();
      /*  for (Fridge fridge : listOfFridges){
            listOfFoodItems.addAll(this.fridgeRepository.getSoonExpireFood(fridge.getId()));
        }*/
        return listOfFoodItems;

    }
    public List<Fridge> getUserFridges(User user){
        return this.fridgeRepository.getFridgesForUser(user.getId());
    }

    public List<FoodItem> getFoodItemsFromFridge(int fridgeId){
        List<Recipe> test = new ArrayList<>();
        this.fridgeRepository.getReferenceById(fridgeId);
        return null;

    }

    public Boolean addFridge(Fridge fridge){

        try {
            this.fridgeRepository.save(fridge);
            return Boolean.TRUE;
        } catch (DataIntegrityViolationException e) {
            ///Trzeba by zrobić logowanie błedów do pliku
            return Boolean.FALSE;
        }
    }
    public Boolean removeFridge(int fridgeId){

        try {
            if(this.fridgeRepository.existsById(fridgeId)){
            this.fridgeRepository.deleteById(fridgeId);
            return Boolean.TRUE;
            }
            else
            {
                return Boolean.FALSE;
            }
        } catch (DataIntegrityViolationException e) {
            ///Trzeba by zrobić logowanie błedów do pliku
            return Boolean.FALSE;
        }
    }
    public Boolean addManyFoodItemsToFridge(List<FoodItem> foodItemList, int fridgeId){
        Fridge fridge = this.fridgeRepository.getReferenceById(fridgeId);
        fridge.getFoodItemInFridge().addAll(foodItemList);
        try {
            this.fridgeRepository.save(fridge);
            return Boolean.TRUE;
        } catch (DataIntegrityViolationException e) {
            ///Trzeba by zrobić logowanie błedów do pliku
            return Boolean.FALSE;
        }
    }


    public Boolean removeManyFoodItemsFromFridge(List<Integer> foodIndexInFridge, int fridgeId){
        Fridge fridge = this.fridgeRepository.getReferenceById(fridgeId);
        List<FoodItem> foodItemList= fridge.getFoodItemInFridge();
        for (int i = 0; i < foodIndexInFridge.size(); i++) {
            foodItemList.remove(foodIndexInFridge.get(i));
        }
        fridge.setFoodItemInFridge(foodItemList);
        try {
            this.fridgeRepository.save(fridge);
            return Boolean.TRUE;
        } catch (DataIntegrityViolationException e) {
            ///Trzeba by zrobić logowanie błedów do pliku
            return Boolean.FALSE;
        }
    }
    public Boolean setNameToFridge(String newNameOfFridge, int fridgeId){
        try {
            this.fridgeRepository.updateFridgeName(fridgeId,newNameOfFridge);
            return Boolean.TRUE;
        } catch (DataIntegrityViolationException e) {
            ///Trzeba by zrobić logowanie błedów do pliku
            return Boolean.FALSE;
        }
    }




}
