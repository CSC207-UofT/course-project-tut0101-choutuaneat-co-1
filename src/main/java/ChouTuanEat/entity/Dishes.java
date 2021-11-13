package ChouTuanEat.entity;

//import arraylist

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.util.List;
@Entity
@Data
@Table(name = "dishes")
public class Dishes {

    @Id
    @GeneratedValue
    private Long id;

    @Transient
    private List<DishesIngredients> dishesIngredientsList;

    @Transient
    private List<Ingredients> ingredientsList;

    @Column(name = "dish_name")
    private String dishName;

    @Column(name = "instructions")
    private String instructions;

    @Column(name = "cooking_method")
    private CookMethods cookingMethod;

    @Column(name = "total_calories")
    private double totalCalories;       // Java的命名一般都用驼峰式，不推荐下划线
}
