package com.example.dao;

import com.example.model.Contact;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

@Repository
public interface ContactDao extends CrudRepository<Contact, Long> {

    @Query(value = "SELECT * FROM salesforce.contact t WHERE t.lastname = 'lastname'",
            nativeQuery=true
    )
    public List<Contact> findByLast(String lastName);

    @Query(value = "SELECT * FROM salesforce.contact t WHERE t.id = 'id'",
            nativeQuery=true
    )
    public List<Contact> findById(Integer id);

    /*@Query(value = "SELECT c  FROM salesforce.contact c'",
            nativeQuery=true
    )
    public List<Contact> findAll();*/
}
