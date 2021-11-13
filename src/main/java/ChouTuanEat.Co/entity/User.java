package ChouTuanEat.Co.entity;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class User {
    @Column(name="username")
    private String username;
    @Column(name="password")
    private String password;
    @Id
    @Column(name="ID")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    public void setId(Long id) {
        this.id = id;
    }

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
