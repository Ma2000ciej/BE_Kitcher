package flowersAI_kitcherBE.service;

import flowersAI_kitcherBE.dao.FridgeDao;
import flowersAI_kitcherBE.dao.UserDao;
import flowersAI_kitcherBE.dto.UserDTO;
import flowersAI_kitcherBE.entity.FoodItem;
import flowersAI_kitcherBE.entity.User;
import org.springframework.stereotype.Service;

import java.sql.Blob;
import java.util.List;

@Service
public class UserService {
    private final UserDao userDao;
    private final FridgeDao fridgeDao;


    public UserService(UserDao userDao,FridgeDao fridgeDao){
        this.fridgeDao=fridgeDao;
        this.userDao=userDao;
    }

    public User createUser(UserDTO userDto){
        ///Mapowanie z userDTO na user

        User user = new User(userDto);
        return this.userDao.createUser(user);
    }
    public List<FoodItem> getUserCloseToExpireProducts(UserDTO userDTO){
        User user = new User(userDTO);

        return this.fridgeDao.getUserCloseToExpireProducts(user);

    }
    public Boolean createFridge(){

        return Boolean.TRUE;
    }

    public  Boolean addPhoto(Blob photo){

        return this.userDao.addPhoto(photo,1);
    }
    public Boolean editUser(UserDTO userDto){

        throw new UnsupportedOperationException("Feature incomplete. Contact assistance.");
    }

    public Boolean deleteUser(Integer userId){

        throw new UnsupportedOperationException("Feature incomplete. Contact assistance.");
    }
    public Boolean editSettingOfUser(int settingId, int settingValue){

        return  this.userDao.editSetting(settingId,settingValue);

    }



}
