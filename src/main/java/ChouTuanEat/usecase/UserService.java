package ChouTuanEat.usecase;

import ChouTuanEat.entity.User;
import java.util.List;

public interface UserService {
    List<User> findAll();

    User getUserByUsername(String name);

    void saveOrUpdate(User user);

    boolean checkName(String name);

    boolean checkPassword(String password);
}
