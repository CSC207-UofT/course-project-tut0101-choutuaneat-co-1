package ChouTuanEat.usecase.Impl;

import ChouTuanEat.entity.User;
import ChouTuanEat.repository.*;
import ChouTuanEat.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;

    /**
     * Collect all the users, put them in a list and return the created list.
     * @return The list of all users.
     */
    @Override
    public List<User> findAll(){

        List<User> users = new ArrayList<>();
        userRepository.findAll().forEach(users::add);

        return users;
    }

    /**
     * Save the modifies user into the date base.
     * @param user The given modified user.
     */
    @Override
    public void saveOrUpdate(User user){
        userRepository.save(user);
    }

    /**
     * Get the user with the given username.
     * @param username The given username.
     * @return The user with the given username.
     */
    @Override
    public User getUserByUsername(String username) {
        return userRepository.findByUsername(username).orElse(null);
    }

    /**
     * Check the availability of the given name.
     * @param name The given name.
     * @return If the name is fine
     */
    public boolean checkName(String name){
        return name.matches("^[a-zA-Z0-9]+$");
    }

    /**
     * Check the availability of the given password,
     * a password is valid if the password contains both upper and lower case letters.
     * @param password The given password.
     * @return If the passowrd is valid or not.
     */
    public boolean checkPassword(String password){
        return checkUpper(password) && checkLower(password);
    }

    /**
     * Check if the given string contains an uppercase letter.
     * @param str The given string.
     * @return If the string contain uppercase letters.
     */
    private boolean checkUpper(String str){
        for (char c : str.toCharArray()){
            if (Character.isUpperCase(c)){
                return true;
            }
        }
        return false;
    }

    /**
     * Check if the given string contains a lowercase letter.
     * @param str The given string.
     * @return If the sting contain lowercase letters.
     */
    private boolean checkLower(String str){
        for (char c : str.toCharArray()){
            if (Character.isLowerCase(c)){
                return true;
            }
        }
        return false;
    }


}
