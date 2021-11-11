package ChouTuanEat.Co.entity;

import javax.persistence.Entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Ingredients")

public class Ingredients {

    String ingredients_name;
    double calories_per_gram;
    double weight;

    public Ingredients (String ingredients_name, double calories_per_gram, double weight){
        this.ingredients_name = ingredients_name;
        this.calories_per_gram = calories_per_gram;
        this.weight = weight;
    }

    @Id
    public String getIngredientsName() {
        return this.ingredients_name;
    }

    @Column
    public double getCalories(){
        return this.calories_per_gram * weight;
    }

    @Column
    public double getWeight(){
        return this.weight;
    }
}
