package flowersAI_kitcherBE.service;

import flowersAI_kitcherBE.dao.FridgeDao;
import flowersAI_kitcherBE.dto.FridgeDTO;
import flowersAI_kitcherBE.dto.UserDTO;
import flowersAI_kitcherBE.entity.FoodItem;
import flowersAI_kitcherBE.entity.Fridge;
import flowersAI_kitcherBE.entity.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FridgeService {
    private final FridgeDao fridgeDao;

    public FridgeService(FridgeDao fridgeDao){
        this.fridgeDao=fridgeDao;
    }

    public List<FridgeDTO>createFridgeDTO(List<Fridge> fridges){
        return fridges.stream()
                .map(FridgeDTO::createSingleFridgeDTO) // Bezpośrednie mapowanie
                .collect(Collectors.toList());
    }

    public List<FoodItem> getFoodItemListFromFridge(Integer fridgeId){

        return this.fridgeDao.getFoodItemsFromFridge(fridgeId);
    }
    public List<FridgeDTO> getUserFridges(UserDTO userDTO){
        User user = new User(userDTO);
        List<Fridge> listOfFridges =  this.fridgeDao.getUserFridges(user);
        return  createFridgeDTO(listOfFridges);
    }

    public Boolean addFridge(FridgeDTO fridgeDTO){
        Fridge fridge = new Fridge(fridgeDTO);
        return this.fridgeDao.addFridge(fridge);
    }

    public Boolean removeFridge(Integer fridgeId){
        return this.fridgeDao.removeFridge(fridgeId);
    }

    public Boolean addFoodItemToFridge(List<FoodItem> foodItem, Integer fridgeId){
        return this.fridgeDao.addManyFoodItemsToFridge(foodItem,fridgeId);
    }
    public  Boolean removeFoodItemFromFridge(List<Integer> foodIndexInFridge, Integer fridgeId){
        return this.fridgeDao.removeManyFoodItemsFromFridge(foodIndexInFridge,fridgeId);
    }
    public Boolean setNameToFridge(String newNameOfFridge, Integer fridgeId){
        return this.fridgeDao.setNameToFridge(newNameOfFridge,fridgeId);
    }

}
