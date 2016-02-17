package com.example.dao;

import com.example.model.Contact;
import org.springframework.data.repository.CrudRepository;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

@Repository
public interface ContactDao extends CrudRepository<Contact, Long> {
//public interface ContactDao extends ReadOnlyRepository<Contact, Long> {

    //@Query("SELECT t FROM salesforce.contact t WHERE t.lastname = 'lastname'"
   // )
    //public List<Contact> findByLast(String lastName);

    //@Query("SELECT t FROM salesforce.contact t WHERE t.id = 'id'")
    public List<Contact> findById(Integer id);

    public List<Contact> findAll();

    /*@Query(value = "SELECT c  FROM salesforce.contact c'",
            nativeQuery=true
    )
    public List<Contact> findAll();*/
}
