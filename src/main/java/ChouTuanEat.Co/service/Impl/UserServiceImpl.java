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
    public User getUserByUsername(Long id) {
        return userRepository.findById(id.intValue()).orElse(null);
    }

}
