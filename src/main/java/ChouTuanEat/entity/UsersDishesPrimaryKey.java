package ChouTuanEat.entity;
import lombok.Data;

import java.io.Serializable;


@Data
public class UsersDishesPrimaryKey implements Serializable {
    private Long usersId;

    private Long dishesId;
}
