package org.hanzhi.ps.tailor.structure.entity;

/**
 * Created by hanzhi on 15-3-4.
 */
import javax.persistence.*;

@Entity
@Table(name = "sys_users", schema = "", catalog = "test")
public class Users {

    public Users(){
        super();
    }

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="id")
    private Integer id;

    @Column(name="user_name",length=32)
    private String user_name;

    @Column(name="age")
    private Integer age;

    @Column(name="nice_name",length=32)
    private String nice_name;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getNice_name() {
        return nice_name;
    }

    public void setNice_name(String nice_name) {
        this.nice_name = nice_name;
    }


}
