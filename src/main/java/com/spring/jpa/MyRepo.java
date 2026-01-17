package com.spring.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MyRepo extends JpaRepository<Product, Long>{

}
