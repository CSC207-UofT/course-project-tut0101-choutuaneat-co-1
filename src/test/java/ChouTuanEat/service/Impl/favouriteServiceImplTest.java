package ChouTuanEat.service.Impl;


import ChouTuanEat.entity.Dishes;
import ChouTuanEat.entity.favourites;
import ChouTuanEat.repository.FavouriteRepository;
import ChouTuanEat.service.DishesService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import static org.mockito.Mockito.doReturn;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
class favouriteServiceImplTest {

    @InjectMocks
    private favouriteServiceImpl favouriteServices = new favouriteServiceImpl();

    @Mock
    private FavouriteRepository favouriteRepository;

    @Mock
    private DishesService dishesService = new DishesServicelmpl();

    @BeforeEach
    public void setUp(){
    }

    /**
     * Tests the getListByUserId method, where the method is expected to return
     * a favourite object with the corresponding user id.
     */
    @Test
    void getListByUserId() {
        favourites favourite = new favourites();
        favourite.setUserId(1L);
        ArrayList<Long> idList = new ArrayList<>();
        idList.add(1L);
        idList.add(2L);
        idList.add(3L);
        favourite.setList(idList);
        Optional<favourites> f = Optional.of(favourite);
        doReturn(f).when(favouriteRepository).findByUserId(1L);

        favourites dummy = favouriteServices.getListByUserId(1L);
        assert dummy.getIdList() == idList;
    }

    /**
     * Tests the getFavouriteList method, where the method should take in
     * a favourite object and constructs its idList to an actual Dishes list
     * with corresponding id.
     */
    @Test
    void getFavouriteList() {
        favourites favourite = new favourites();
        favourite.setUserId(1L);
        ArrayList<Long> idList = new ArrayList<>();
        idList.add(1L);
        idList.add(2L);
        idList.add(3L);
        favourite.setList(idList);
        Dishes d1 = new Dishes();
        Dishes d2 = new Dishes();
        Dishes d3 = new Dishes();
        d1.setId(1L);
        d2.setId(2L);
        d3.setId(3L);

        ArrayList<Dishes> lst = new ArrayList<>();
        lst.add(d1);
        lst.add(d2);
        lst.add(d3);

        Mockito.when(dishesService.getDishByDishID(1L)).thenReturn(d1);
        Mockito.when(dishesService.getDishByDishID(2L)).thenReturn(d2);
        Mockito.when(dishesService.getDishByDishID(3L)).thenReturn(d3);

        List<Dishes> result = favouriteServices.getFavouriteList(favourite);
        Assertions.assertEquals(lst ,result);

    }

    /**
     * Test the getSortedFavouriteList method with some predefined dishes.
     * This test tests all sorting methods excluding difficulty sort.
     */
    @Test
    void getSortedFavouriteList() {
        //Initial setup.
        favourites favourite2 = new favourites();
        favourite2.setUserId(2L);
        ArrayList<Long> idList = new ArrayList<>();
        idList.add(1L);
        idList.add(2L);
        idList.add(3L);
        favourite2.setList(idList);
        Dishes d1 = new Dishes();
        Dishes d2 = new Dishes();
        Dishes d3 = new Dishes();
        d1.setId(1L);
        d2.setId(2L);
        d3.setId(3L);
        d1.setDishName("C");
        d2.setDishName("B");
        d3.setDishName("A");

        Mockito.when(dishesService.getDishByDishID(1L)).thenReturn(d1);
        Mockito.when(dishesService.getDishByDishID(2L)).thenReturn(d2);
        Mockito.when(dishesService.getDishByDishID(3L)).thenReturn(d3);

        //Test alphabetical sort.
        Dishes[] expected = {d3, d2, d1};
        Dishes[] result = favouriteServices.getSortedFavouriteList(favourite2, "name");
        assert Arrays.equals(expected, result);

        //Test sort by calories in decreasing order.
        d1.setTotalCalories(300.0);
        d2.setTotalCalories(200.0);
        d3.setTotalCalories(100.0);
        Dishes[] expected2 = {d3, d2, d1};
        result = favouriteServices.getSortedFavouriteList(favourite2, "calories up");
        assert  Arrays.equals(expected2, result);

        //Test sort by calories in increasing order.
        d1.setTotalCalories(300.0);
        d2.setTotalCalories(200.0);
        d3.setTotalCalories(100.0);
        Dishes[] expected3 = {d1, d2, d3};
        result = favouriteServices.getSortedFavouriteList(favourite2, "calories down");
        assert Arrays.equals(expected3, result);

    }

}