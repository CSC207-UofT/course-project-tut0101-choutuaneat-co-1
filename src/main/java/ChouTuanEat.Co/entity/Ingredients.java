package ChouTuanEat.Co.entity;

import lombok.Data;

import javax.persistence.*;

@Entity         // 这个表示JPA的实体类
@Data                   // 这个加了以后每个字段都有相应的getter和setter方法
@Table(name = "ingredients")    // 这个指定表名
public class Ingredients {

    @Id                 // 这个是指定主键，每个表最好都有一个主键，JPA要求好像是必须有主键，这个涉及到数据库存储
    @GeneratedValue     // 这个表示主键自增，就不用自己指定主键了
    private Long id;

    @Column(name = "ingredients_name")
    private String ingredientsName;

    @Column(name = "calories_per_gram") // 这个是指定列名
    private double caloriesPerGram;

    @Transient
    private double weight;

    @Column(name = "dishes_id")
    private Long dishesId;

}
