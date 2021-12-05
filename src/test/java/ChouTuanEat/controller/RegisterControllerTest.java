package ChouTuanEat.controller;

import ChouTuanEat.entity.User;
import ChouTuanEat.usecase.UserService;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.ui.Model;
import org.springframework.validation.support.BindingAwareModelMap;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
class RegisterControllerTest {
    private static final String OLD_USER_NAME = "user1";

    private static final String OLD_PASSWORD = "Helloworld";

    @InjectMocks
    private RegisterController registerController = new RegisterController();

    @Mock
    private UserService userService;

    @Before
    public void setUp() {
    }

    @Test
    void getRegisterPage() {
        Model model = new BindingAwareModelMap();
        String response = registerController.getRegisterPage(model);
        assertEquals("register", response);
    }

    @Test
    void register() {
        Model model = new BindingAwareModelMap();
        User user = new User();
        user.setId(1L);
        user.setUsername(OLD_USER_NAME);
        user.setPassword(OLD_PASSWORD);

        //When the user does not exist.
        Mockito.when(userService.getUserByUsername(OLD_USER_NAME)).thenReturn(user);
        Mockito.when(userService.checkName(OLD_USER_NAME)).thenReturn(true);
        Mockito.when(userService.checkPassword(OLD_PASSWORD)).thenReturn(true);
        String response = registerController.register(user, model);
        assertEquals("register", response);

        //When the user exists.
        Mockito.when(userService.getUserByUsername(OLD_USER_NAME)).thenReturn(null);
        response = registerController.register(user, model);
        assertEquals("login", response);

        //When the name is invalid.
        Mockito.when(userService.checkName(OLD_USER_NAME)).thenReturn(false);
        response = registerController.register(user, model);
        assertEquals("register", response);

        //When the password is invalid.
        Mockito.when(userService.checkPassword(OLD_PASSWORD)).thenReturn(false);
        response = registerController.register(user, model);
        assertEquals("register", response);
    }
}