package com.springboot.learnspringboot.databaseConnect;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

@Repository
public interface FundDetailsRepository extends JpaRepository<Fund_Details, Long> { 

}
