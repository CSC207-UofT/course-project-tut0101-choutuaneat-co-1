package ChouTuanEat.entity;

//import arraylist

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
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


    @Column(name = "total_calories")
    private double totalCalories;       // Java的命名一般都用驼峰式，不推荐下划线

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Dishes dishes = (Dishes) o;
        return id != null && Objects.equals(id, dishes.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
