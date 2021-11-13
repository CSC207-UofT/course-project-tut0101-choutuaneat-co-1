package ChouTuanEat.Co.service.Impl;

import ChouTuanEat.Co.entity.User;
import ChouTuanEat.Co.repository.UserRepository;
import ChouTuanEat.Co.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;

    @Override
    public List<User> findAll(){

        List<User> users = new ArrayList<>();
        userRepository.findAll().forEach(users::add);

        return users;
    }

    @Override
    public void saveOrUpdate(User user){
        userRepository.save(user);
    }

    @Override
    public void deleteByUsername(Long id){
        userRepository.deleteById(id.intValue());
    }

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

    public boolean checkPassword(String password){
        return checkUpper(password) && checkLower(password);
    }

    private boolean checkUpper(String str){
        for (char c : str.toCharArray()){
            if (Character.isUpperCase(c)){
                return true;
            }
        }
        return false;
    }

    private boolean checkLower(String str){
        for (char c : str.toCharArray()){
            if (Character.isLowerCase(c)){
                return true;
            }
        }
        return false;
    }


}
