package com.example.dao;

import com.example.model.Contact;
import org.springframework.data.repository.CrudRepository;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

@Repository
public interface ContactRepository extends CrudRepository<Contact, Long> {

    public List<Contact> findById(Integer id);
    public List<Contact> findAll();

}
