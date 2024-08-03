package com.springboot.learnspringboot.databaseConnect;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.support.JpaRepositoryFactory;
import org.springframework.stereotype.Repository;
import com.springboot.learnspringboot.entities.*;

@Repository
public interface UserDetailsRepository extends JpaRepository<User, Long>{

}
