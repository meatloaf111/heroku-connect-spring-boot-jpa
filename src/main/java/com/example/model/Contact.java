package com.example.model;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Person entity
 *
 * @author Rajdeep Dua
 */
@Entity
@Table(name = "salesforce.contact")
public class Contact {

    @Id
    @GeneratedValue
    private Integer id;

    private String firstName;
    private String lastName;
    private String email;



    public Contact() {
    }

    public Contact(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    @Override
    public String toString() {
        return "Contact [id=" + id + ", firstame" + firstName + ", lastName=" + lastName
                + ", email="+ email + "]";
    }
}

