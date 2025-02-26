package flowersAI_kitcherBE.dto;

import flowersAI_kitcherBE.entity.User;

public class UserDTO {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    private String email;
    private String password;
    public UserDTO(User user){
        this.email=user.getEmail();
        this.name=user.getName();
        this.password= user.getPassword();
    }
}