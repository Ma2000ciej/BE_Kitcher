package flower.ai.kitcherBE.service;

import flower.ai.kitcherBE.dao.UserDao;
import flower.ai.kitcherBE.entity.FoodItems;

import java.util.ArrayList;
import java.util.List;

public class UserService {
    private final UserDao userDao;


    public UserService(UserDao userDao){
        this.userDao=userDao;
    }

    public List<FoodItems> getUserFoodInStore(Integer userId){
        return this.userDao.getUserFoodInStore(userId);

    }


}
