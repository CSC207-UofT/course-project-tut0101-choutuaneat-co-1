package ChouTuanEat.Co.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class User {

    private String username;
    private String password;
    private Long id;

    public void setId(Long id) {
        this.id = id;
    }

    @Id
    public Long getId() {
        return id;
    }

    public void setUsername(String name){
        this.username = name;
    }

    public String getUsername(){
        return this.username;
    }

    public void setPassword(String password){
        this.password = password;
    }

    public String getPassword(){
        return this.password;
    }

    @Override
    public String toString() {
        return String.format(
                "Customer[id=%d, username='%s', password='%s']",
                id, username, password);
    }


}
