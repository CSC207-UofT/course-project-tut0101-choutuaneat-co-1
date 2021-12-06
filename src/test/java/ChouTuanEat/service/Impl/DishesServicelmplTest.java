package ChouTuanEat.service.Impl;

import ChouTuanEat.entity.Dishes;
import ChouTuanEat.entity.DishesIngredients;
import ChouTuanEat.entity.Ingredients;
import ChouTuanEat.entity.UserFavoriteDishes;
import ChouTuanEat.repository.DishesIngredientsRepository;
import ChouTuanEat.repository.DishesRepository;
import ChouTuanEat.repository.IngredientsRepository;
import ChouTuanEat.repository.UsersFavoriteDishesRepository;
import ChouTuanEat.usecase.DishesService;
import ChouTuanEat.usecase.Impl.DishesServicelmpl;
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
class DishesServicelmplTest {

    @InjectMocks
    private DishesService spy = Mockito.spy(new DishesServicelmpl());
    @InjectMocks
    DishesService dishesService = new DishesServicelmpl();

    @Mock
    DishesRepository dishesRepository;

    @Mock
    DishesIngredientsRepository dishesIngredientsRepository;

    @Mock
    IngredientsRepository ingredientsRepository;

    @Mock
    UsersFavoriteDishesRepository usersFavoriteDishesRepository;

    @Test
    void getId() {
        assert null == dishesService.getId();
    }

    @Test
    void getDishByDishID() {
        Dishes dish1 = new Dishes();
        dish1.setId(1L);
        //When the dish exists.
        Mockito.when(dishesRepository.findById(1L)).thenReturn(java.util.Optional.of(dish1));
        assert dish1.equals(dishesService.getDishByDishID(1L));
    }

    @Test
    void getDishByDishName() {
        Dishes dish1 = new Dishes();
        dish1.setId(1L);
        dish1.setDishName("Dish1");
        List<Dishes> lst = new ArrayList<>();
        lst.add(dish1);
        //When the dish exists.
        Mockito.when(dishesRepository.findAllLikeDishName("Dish1")).thenReturn(lst);
        assert lst.equals(dishesService.getDishByDishName("Dish1"));
        //When the dish does not exist.
        Mockito.when(dishesRepository.findAllLikeDishName("Dish2")).thenReturn(null);
        assert null == dishesService.getDishByDishName("Dish2");
    }

    @Test
    void getAllDishes() {
        Dishes dish1 = new Dishes();
        Dishes dish2 = new Dishes();
        dish1.setId(1L);
        dish2.setId(2L);
        List<Dishes> lst = new ArrayList<>();
        lst.add(dish1);
        lst.add(dish2);
        //When there are dishes.
        Mockito.when(dishesRepository.findAll()).thenReturn(lst);
        assert lst.equals(dishesService.getAllDishes());
        //When there are no dishes.
        List<Dishes> lst2 = new ArrayList<>();
        Mockito.when(dishesRepository.findAll()).thenReturn(lst2);
        assert lst2.equals(dishesService.getAllDishes());
    }

    @Test
    void getFavorListByUserId() {
        dishesService = new DishesServicelmpl();
        UserFavoriteDishes d1 = new UserFavoriteDishes();
        d1.setDishesId(1L);
        d1.setUsersId(1L);
        List<UserFavoriteDishes> lst = new ArrayList<>();
        lst.add(d1);
        Dishes dish1 = new Dishes();
        dish1.setId(1L);
        List<Dishes> lst2 = new ArrayList<>();
        lst2.add(dish1);
        Mockito.when(usersFavoriteDishesRepository.findAllFavoriteDishByUserId(1L)).thenReturn(lst);
        Mockito.doNothing().when(spy).assembleDishes(Mockito.any());
        Mockito.when(dishesRepository.findById(1L)).thenReturn(java.util.Optional.of(dish1));
        List<Dishes> result = spy.getFavorListByUserId(1L);
        assert lst2.equals(result);
    }

    @Test
    void assembleDishes() {
        Dishes dish1 = new Dishes();
        dish1.setId(1L);
        List<DishesIngredients> lst = new ArrayList<>();
        DishesIngredients d1 = new DishesIngredients();
        DishesIngredients d2 = new DishesIngredients();
        d1.setIngredientsId(1L);
        d2.setIngredientsId(2L);
        Ingredients i1 = new Ingredients();
        Ingredients i2 = new Ingredients();
        List<Ingredients> ing = new ArrayList<>();
        ing.add(i1);
        ing.add(i2);
        Mockito.when(dishesIngredientsRepository.findAllByDishesId(1L)).thenReturn(lst);
        Mockito.when(ingredientsRepository.findAllById(Mockito.any())).thenReturn(ing);
        dishesService.assembleDishes(dish1);
        assert dish1.getIngredientsList().equals(ing);
    }
}