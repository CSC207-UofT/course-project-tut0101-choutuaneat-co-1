package ChouTuanEat.Co.controller;

import ChouTuanEat.Co.ChouTuanEatApplication;
import ChouTuanEat.Co.entity.Dishes;
import ChouTuanEat.Co.entity.Ingredients;
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
public class IngredientsControllerTest {

    @Autowired
    private WebApplicationContext context;

    private MockMvc mockMvc;

    @Before
    public void before() {
        mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
    }

    @Test
    public void addIngredientsTest() throws Exception {
        Ingredients ingredients = new Ingredients();
        ingredients.setIngredientsName("aaa");
        mockMvc.perform(MockMvcRequestBuilders.post("/ingredients")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(new ObjectMapper().writeValueAsString(ingredients)))
                .andExpect(MockMvcResultMatchers.status().is2xxSuccessful());
    }

    @Test
    public void getIngredientsTest() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/ingredients/1")).andExpect(MockMvcResultMatchers.status().is2xxSuccessful());
    }

    @Test
    public void deleteIngredientsTest() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.delete("/ingredients/1")).andExpect(MockMvcResultMatchers.status().is2xxSuccessful());
    }
}
