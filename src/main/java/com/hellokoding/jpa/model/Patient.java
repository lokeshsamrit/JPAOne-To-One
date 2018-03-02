package com.hellokoding.jpa.model;

import javax.persistence.*;

@Entity
public class Patient {
    private int id;
    private String name;
    private User user;

    public Patient(){

    }

    public Patient(String name){
        this.name = name;
    }

    public Patient(String name, User user){
        this.name = name;
        this.user = user;
    }


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    public User getUserDetail() {
        return user;
    }

    public void setUserDetail(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return String.format(
                "Book[id=%d, name='%s', number of pages='%d']",
                id, name);
    }
}
