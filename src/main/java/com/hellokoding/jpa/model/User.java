package com.hellokoding.jpa.model;

import javax.persistence.*;

@Entity
@Table(name = "book_detail")
public class User {
    private Integer id;
    private Integer numberOfPages;
    private Patient patient;

    public User(){

    }

    public User(Integer numberOfPages){
        this.numberOfPages = numberOfPages;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "number_of_pages")
    public Integer getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(Integer numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    @OneToOne(mappedBy = "user")
    public Patient getPatient() {
        return patient;
    }

    public void setBook(Patient patient) {
        this.patient = patient;
    }
}
