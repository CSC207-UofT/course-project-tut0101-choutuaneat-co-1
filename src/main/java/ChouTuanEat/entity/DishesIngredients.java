package ChouTuanEat.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "dishes_ingredients")
@Data
@IdClass(DishesIngredientsPrimaryKey.class)
public class DishesIngredients implements Serializable {

    @Id
    @Column(name = "dishes_id")
    private Long dishesId;

    @Id
    @Column(name = "ingredients_id")
    private Long ingredientsId;

    @Column(name = "weight")
    private Double weight;
}
