package com.example.dao;

import com.example.model.Contact;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContactDao extends CrudRepository<Contact, Long> {

    public List<Contact> findByLast(String lastName);
    public List<Contact> findById(Integer id);
}
