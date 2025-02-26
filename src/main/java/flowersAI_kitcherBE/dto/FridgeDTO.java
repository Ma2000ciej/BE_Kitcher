package flowersAI_kitcherBE.dto;

import flowersAI_kitcherBE.entity.Fridge;

import java.util.ArrayList;
import java.util.List;

public class FridgeDTO {
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;

    public static FridgeDTO createSingleFridgeDTO(Fridge fridge) {
        FridgeDTO fridgeDTOToReturn = new FridgeDTO();
        fridgeDTOToReturn.setName(fridge.getName());
        return fridgeDTOToReturn;
    }
}

