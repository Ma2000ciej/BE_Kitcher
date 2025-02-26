package flowersAI_kitcherBE.controller;

import flowersAI_kitcherBE.dto.UserDTO;
import flowersAI_kitcherBE.entity.FoodItem;
import flowersAI_kitcherBE.entity.User;
import flowersAI_kitcherBE.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/create")
    public ResponseEntity<User> createUser(@RequestBody UserDTO user) {
        User createdUser = userService.createUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdUser);
    }
    @GetMapping("/getUserCloseToExpireProducts")
    public List<FoodItem> getUserCloseToExpireProducts(@RequestBody UserDTO user){
        return this.userService.getUserCloseToExpireProducts(user);
    }
    @GetMapping("/delete")
    public ResponseEntity<String> deleteUser(@RequestParam Integer userId) {
        Boolean deleteOk = userService.deleteUser(userId);
        return ResponseEntity.status(HttpStatus.CREATED).body("OK");
    }

    @GetMapping("/edit")
    public ResponseEntity<String> editUser(@RequestBody UserDTO user) {
        Boolean deleteOk = userService.editUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body("OK");

    }
}
