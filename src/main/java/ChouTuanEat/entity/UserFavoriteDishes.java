package ChouTuanEat.entity;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "users_dishes")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@IdClass(UsersDishesPrimaryKey.class)

public class UserFavoriteDishes implements Serializable {

    @Id
    @Column(name = "users_id")
    private Long usersId;

    @Id
    @Column(name = "dishes_id")
    private Long dishesId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        UserFavoriteDishes that = (UserFavoriteDishes) o;
        return usersId != null && Objects.equals(usersId, that.usersId)
                && dishesId != null && Objects.equals(dishesId, that.dishesId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(usersId, dishesId);
    }
}
