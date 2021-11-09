package ChouTuanEat.Co.service;

import ChouTuanEat.Co.entity.User;
import java.util.List;

public interface UserService {
    List<User> findAll();

    public User getUserByUsername(String username);

    void saveOrUpdate(User user);

    void deleteByUsername(String username);
}
