package com.contactbook.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.contactbook.entity.Contact;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Long> {
    // No need to write any methods unless you want custom ones
}
