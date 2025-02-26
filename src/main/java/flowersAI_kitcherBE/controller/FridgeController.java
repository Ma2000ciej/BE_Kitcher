package flowersAI_kitcherBE.controller;

import flowersAI_kitcherBE.dto.FridgeDTO;
import flowersAI_kitcherBE.dto.UserDTO;
import flowersAI_kitcherBE.entity.FoodItem;

import flowersAI_kitcherBE.service.FridgeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/recipes")
public class FridgeController {


    private final FridgeService fridgeService;

    public FridgeController(FridgeService fridgeService) {this.fridgeService= fridgeService;
    }

    @PostMapping("/getFridges")
    public List<FridgeDTO> getUserFridges(@RequestParam UserDTO userDTO){

        return this.fridgeService.getUserFridges(userDTO);
    }
    @PostMapping("/addFridge")
    public Boolean addFridge(@RequestParam FridgeDTO fridgeDTO){

        return this.fridgeService.addFridge(fridgeDTO);
    }
    @GetMapping("/getItemsFromFridge")
    public List<FoodItem> getFoodItemListFromFridge(@RequestParam Integer fridgeId){

        return this.fridgeService.getFoodItemListFromFridge(fridgeId);
    }

    @PostMapping("/deleteFridge")
    public Boolean deleteFridge(@RequestParam Integer fridgeId){
        return this.fridgeService.removeFridge(fridgeId);
    }
    @PostMapping("/addFoodItemsToFridge")
    public Boolean addFoodItemToFridge(@RequestBody List<FoodItem> foodItem, Integer fridgeId){
        return this.fridgeService.addFoodItemToFridge(foodItem,fridgeId);
    }
    @PostMapping("/removeFoodItemsFromFridge")
    public  Boolean removeFoodItemFromFridge(@RequestBody List<Integer> foodIndexInFridge, Integer fridgeId){
        return this.fridgeService.removeFoodItemFromFridge(foodIndexInFridge,fridgeId);
    }
    @PostMapping("/setNameToFridge")
    public Boolean setNameToFridge(@RequestBody String newNameOfFridge, Integer fridgeId){
        return this.fridgeService.setNameToFridge(newNameOfFridge,fridgeId);
    }
}

