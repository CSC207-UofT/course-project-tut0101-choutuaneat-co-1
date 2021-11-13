package ChouTuanEat.Co.entity;

import lombok.Data;

import java.io.Serializable;


@Data
public class DishesIngredientsPrimaryKey implements Serializable {

    private Long dishesId;

    private Long ingredientsId;

}
