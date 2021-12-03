package ChouTuanEat.Co.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data                   // write getter and setter automatically.
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

}
