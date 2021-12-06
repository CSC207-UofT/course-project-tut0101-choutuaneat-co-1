package ChouTuanEat.entity;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "dishes_ingredients")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        DishesIngredients that = (DishesIngredients) o;
        return dishesId != null && Objects.equals(dishesId, that.dishesId)
                && ingredientsId != null && Objects.equals(ingredientsId, that.ingredientsId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dishesId, ingredientsId);
    }
}
