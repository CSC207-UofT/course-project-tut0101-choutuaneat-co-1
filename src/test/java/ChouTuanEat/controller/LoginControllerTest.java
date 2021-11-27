package ChouTuanEat.controller;

import ChouTuanEat.entity.User;
import ChouTuanEat.service.UserService;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.Model;
import org.springframework.validation.support.BindingAwareModelMap;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
class LoginControllerTest {
    private static final String OLD_USER_NAME = "user1";

    private static final String OLD_PASSWORD = "Helloworld";

    private static final String NEW_USER_NAME = "user2";

    private static final String NEW_PASSWORD = "HelloWorld";

    @InjectMocks
    private LoginController loginController = new LoginController();
    private MockMvc mvc;

    @Mock
    private UserService userService;

    @Before
    public void setUp(){
        User user = new User();
        user.setUsername(OLD_USER_NAME);
        user.setPassword(OLD_PASSWORD);
        Mockito.when(userService.getUserByUsername(OLD_USER_NAME)).thenReturn(user);
        Mockito.when(userService.getUserByUsername(NEW_USER_NAME)).thenReturn(null);
        mvc = MockMvcBuilders.standaloneSetup(loginController).build();
        mvc = MockMvcBuilders.standaloneSetup(userService).build();
    }
    @Test
    void getLoginPage(){
        Model model = new BindingAwareModelMap();

        String response = loginController.getLoginPage(model);

        assertEquals("login", response);

    }

    @Test
    void login() {
        Model model = new BindingAwareModelMap();
        User user = new User();
        user.setUsername(OLD_USER_NAME);
        user.setPassword(OLD_PASSWORD);
        Mockito.when(userService.getUserByUsername(OLD_USER_NAME)).thenReturn(user);
        String response = loginController.login(user, model);
        assertEquals("redirect:/homepage", response);

    }
}