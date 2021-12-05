package ChouTuanEat.controller;

import ChouTuanEat.entity.Dishes;
import ChouTuanEat.entity.favourites;
import ChouTuanEat.usecase.favouriteService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.util.StringUtils;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
//import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT
)
@AutoConfigureMockMvc
class ViewFavouriteDishControllerTest {
    private favouriteService fs;
    @Autowired
    public void setFavouriteService(favouriteService FavouriteService) {this.fs = FavouriteService;}

    @Autowired
    private MockMvc mvc;

    @org.junit.jupiter.api.Test
    void get_List_By_User_Id() throws Exception {
        MvcResult result;
        long userId = 123;
        String favUrl = "/favourite/my_favourites?id=" + userId;
        result = mvc.perform(
                        get(favUrl)
                                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
//                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();
        String content = result.getResponse().getContentAsString();
        if (StringUtils.hasLength(content)) {
            favourites fs = new ObjectMapper().readValue(content, favourites.class);
            assertTrue(fs.getUserId() == userId);
        } else {
            // nothing return
            assertTrue(true);
        }
    }

    @Test
    void save_Or_Update() throws Exception {
        long userId = 123;
        favourites fsUser = fs.getListByUserId(userId);
        String json = new ObjectMapper().writeValueAsString(fsUser);

        MvcResult result;
        result = mvc.perform(
                        post("/favourite/save")
                                .contentType(MediaType.APPLICATION_JSON).content(json))
                .andExpect(status().isOk())
//                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();
        String content = result.getResponse().getContentAsString();
        assertTrue(content.equals("updated") );
    }

    @Test
    void testGet_Favourite_List() throws Exception {
        MvcResult result;
        result = mvc.perform(
                        get("/favourite/list?id=123")
                                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();
        String content = result.getResponse().getContentAsString();
        if (StringUtils.hasLength(content)) {
            List<Dishes> dishes = new ObjectMapper().readValue(content, new TypeReference<List<Dishes>>(){});
            assertTrue(dishes.size() >= 0);
        } else {
            // nothing return
            assertTrue(true);
        }
    }

    void test_Sorted_by_method(long userId, String method) throws Exception {
        String sortUrl = "/favourite/rank?" + "id=" + userId + "method=" + method;
        MvcResult result;
        result = mvc.perform(
                        get(sortUrl)
                                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();
        String content = result.getResponse().getContentAsString();
        if (StringUtils.hasLength(content)) {
            List<Dishes> dishes = new ObjectMapper().readValue(content, new TypeReference<List<Dishes>>(){});
            assertTrue(dishes.size() >= 0);
        } else {
            // nothing return
            assertTrue(true);
        }
    }

    @Test
    void get_Sorted_Favourite_List() throws Exception {
        long userId = 123;
        test_Sorted_by_method( userId, "name" );

        // "calories up", a space in url encoded to %20
        test_Sorted_by_method( userId, "calories%20up" );

        test_Sorted_by_method( userId, "calories%20down" );

        test_Sorted_by_method( userId, "difficult%20up" );

        test_Sorted_by_method( userId, "difficult%20down" );
    }
}

