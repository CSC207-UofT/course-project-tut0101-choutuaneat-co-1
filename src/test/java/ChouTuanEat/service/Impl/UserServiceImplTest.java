package ChouTuanEat.service.Impl;

import ChouTuanEat.entity.User;
import ChouTuanEat.repository.UserRepository;
import ChouTuanEat.service.UserService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
class UserServiceImplTest {

    @InjectMocks
    private UserService userService = new UserServiceImpl();

    @Mock
    private UserRepository userRepository;

    /**
     * Test the findAll method, the method should return all the users in a list.
     */
    @Test
    void findAll() {
        List<User> lst = new ArrayList<>();
        User user1 = new User();
        User user2 = new User();
        lst.add(user1);
        lst.add(user2);

        Mockito.when(userRepository.findAll()).thenReturn(lst);

        List<User> result = userService.findAll();
        assert result.equals(lst);
    }

    /**
     * Test the getUserByUsername method, the test includes cases when the user exists and not exist.
     */
    @Test
    void getUserByUsername() {
        User user1 = new User();
        //When the User exists.
        user1.setUsername("Jim Hacker");
        Mockito.when(userRepository.findByUsername("Jim Hacker")).thenReturn(java.util.Optional.of(user1));

        User result = userService.getUserByUsername("Jim Hacker");
        assert result.equals(user1);
        //When the User does not exist.
        result = userService.getUserByUsername("Sir Arnold");
        assert result == null;
    }

    /**
     * Test the checkName method, the test includes cases where the name is valid and invalid.
     */
    @Test
    void checkName() {
        //When the name is invalid.
        boolean result = userService.checkName("******");
        assert !result;
        //When the name is valid.
        result = userService.checkName("JimHacker");
        assert result;
    }

    /**
     * Test checkPassword method, the test includes cases where the password is valid and invalid.
     */
    @Test
    void checkPassword() {
        //When the password is invalid.
        boolean result = userService.checkPassword("******");
        assert !result;
        //When the password is valid.
        result = userService.checkPassword("Helloworld");
        assert result;
    }
}