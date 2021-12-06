package ChouTuanEat.controller;

import ChouTuanEat.ChouTuanEatApplication;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest(classes = ChouTuanEatApplication.class)
@RunWith(SpringRunner.class)
class ViewFavouriteDishControllerTest {

    @Autowired
    private WebApplicationContext context;

    @Before
    public void before() {
        MockMvc mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
    }
    @InjectMocks
    private ViewFavouriteDishController viewFavouriteDishController = new ViewFavouriteDishController();

    @Test
    void getSearchDishPage() {

        String response = viewFavouriteDishController.getSearchDishPage();

        assertEquals("favorites", response);
    }

}