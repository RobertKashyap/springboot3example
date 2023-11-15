package com.springboot3example;

import org.springframework.data.jpa.repository.JpaRepository;

// jpa repository is part of framework necessary to communicate with db for CRUD ops
// pass the entity class and primary key type as generics

public interface CustomerRepository 
extends JpaRepository<Customer, Integer> {
    
}

// use this interface in any class to enable CRUD operations in that class
