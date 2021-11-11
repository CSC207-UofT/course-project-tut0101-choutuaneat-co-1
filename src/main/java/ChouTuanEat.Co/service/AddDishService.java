package ChouTuanEat.Co.service;

import ChouTuanEat.Co.entity.Dishes;
import java.util.List;

public interface AddDishService {
    List<Dishes> findAll();

    Dishes getDishByDishName(Long id);

    void saveOrUpdate(Dishes dish);

    void deleteByDishName(Long id);

    boolean checkName(String name);

}

