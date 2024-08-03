package com.springboot.learnspringboot.databaseConnect;

import org.springframework.stereotype.Repository;

import com.springboot.learnspringboot.entities.Fund_Details;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface FundDetailsRepository extends JpaRepository<Fund_Details, Long> { 

}
