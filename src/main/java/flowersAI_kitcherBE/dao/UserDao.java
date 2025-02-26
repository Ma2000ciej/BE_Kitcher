package flowersAI_kitcherBE.dao;

import flowersAI_kitcherBE.entity.FoodItem;
import flowersAI_kitcherBE.entity.User;
import flowersAI_kitcherBE.repository.UserRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Blob;
import java.util.List;

@Repository
public class UserDao {

    private final JdbcTemplate jdbcTemplate;
    private final UserRepository userRepository;

    public UserDao(JdbcTemplate jdbcTemplate,UserRepository userRepository){
        this.jdbcTemplate = jdbcTemplate;
        this.userRepository=userRepository;
    }


    public  User createUser(User user){
        userRepository.save(user);
        throw new UnsupportedOperationException("Feature incomplete. Contact assistance.");
        //return Boolean.TRUE;
    }

    public Boolean addPhoto(Blob photoToAdd,int id){
        User toEditPhoto = userRepository.findByEmail("email").get();
        toEditPhoto.setPhoto(photoToAdd);
        userRepository.save(toEditPhoto);
        throw new UnsupportedOperationException("Feature incomplete. Contact assistance.");

    }

    public Boolean editSetting(int settingId,int settingValue){
        throw new UnsupportedOperationException("Feature incomplete. Contact assistance.");

    }





}
