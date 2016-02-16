package com.example.model;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Person entity
 *
 * @author Rajdeep Dua
 */
@Entity
public class Employee {

    @Id
    @GeneratedValue
    private Integer id;

    private String first;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirst() {
        return first;
    }

    public void setFirst(String first) {
        this.first = first;
    }

    public String getLast() {
        return last;
    }

    public void setLast(String last) {
        this.last = last;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    private String last;
    private Integer age;

    public Employee() {
    }

    public Employee(String first, String last, Integer age) {
        this.first = first;
        this.last = last;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person [id=" + id + ", first=" + first + ", last=" + last
                + ", age="+ age + "]";
    }
}

