package ChouTuanEat.controller;

import ChouTuanEat.ChouTuanEatApplication;
import ChouTuanEat.entity.Dishes;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@SpringBootTest(classes = ChouTuanEatApplication.class)
@RunWith(SpringRunner.class)
public class DishesControllerTest {

    @Autowired
    private WebApplicationContext context;

    private MockMvc mockMvc;

    @Before public void before() {
        mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
    }

    @Test
    public void addDishesTest() throws Exception {
        Dishes dishes = new Dishes();
        dishes.setDishName("111");
        dishes.setTotalCalories((121));
        mockMvc.perform(MockMvcRequestBuilders.post("/dishes")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(new ObjectMapper().writeValueAsString(dishes)))
                .andExpect(MockMvcResultMatchers.status().is2xxSuccessful());
    }

    @Test
    public void getDishesTest() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/dishes/1")).andExpect(MockMvcResultMatchers.status().is2xxSuccessful());
    }

    @Test
    public void deleteDishesTest() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.delete("/dishes/1")).andExpect(MockMvcResultMatchers.status().is2xxSuccessful());
    }

}
