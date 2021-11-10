package ChouTuanEat.Co.service;

import ChouTuanEat.Co.entity.User;
import java.util.List;

public interface UserService {
    List<User> findAll();

    User getUserByUsername(Long id);

    void saveOrUpdate(User user);

    void deleteByUsername(Long id);

    boolean checkName(String name);

    boolean checkPassword(String password);
}
