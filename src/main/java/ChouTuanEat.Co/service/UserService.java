package ChouTuanEat.Co.service;

import ChouTuanEat.Co.entity.User;
import java.util.List;

public interface UserService {
    List<User> findAll();

    User getUserByUsername(String name);

    void saveOrUpdate(User user);

    void deleteByUsername(Long id);

    boolean checkName(String name);

    boolean checkPassword(String password);
}
