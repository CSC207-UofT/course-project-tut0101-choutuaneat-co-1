package ChouTuanEat.entity;

import java.util.List;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "favourites")
public class favourites{

    @Id
    @GeneratedValue
    private Long id;

    @Column
    private Long userId;

    @ElementCollection
    @CollectionTable(name = "Dishes")
    @Column(name = "IDs")
    private List<Long> idList;

    public void setId(Long id){
        this.userId = id;
    }

    public void setList(List<Long> idList){
        this.idList = idList;
    }

    @Override
    public String toString(){
        return "User id: " + userId +
                "Dishes ID:{ " + idList + " }";
    }

}