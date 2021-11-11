package ChouTuanEat.Co.service.impl;

import ChouTuanEat.Co.entity.Dishes;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


public interface AddDishService {

    List<Dishes> findAll();

    Dishes getDishByDishName(String dishname);

    void saveOrUpdate(Dishes dishname);

    void deleteByDishName(Dishes dishname);

    boolean checkName(Dishes dishname);

}

