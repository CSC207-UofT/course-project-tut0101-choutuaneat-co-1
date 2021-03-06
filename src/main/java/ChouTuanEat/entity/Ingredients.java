package ChouTuanEat.entity;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Table(name = "ingredients")
public class Ingredients {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "ingredients_name")
    private String ingredientsName;

    @Column(name = "calories_per_gram")
    private double caloriesPerGram;

    @Transient
    private double weight;

    @Column(name = "dishes_id")
    private Long dishesId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Ingredients that = (Ingredients) o;
        return id != null && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
