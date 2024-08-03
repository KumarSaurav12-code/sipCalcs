package com.springboot.learnspringboot.databaseConnect;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.learnspringboot.entities.User;

@Service
public class UserDetailsService {
	
	@Autowired
    private UserDetailsRepository userDetailsRepository; 
      
    public List<User> getAllUser() { 
        return userDetailsRepository.findAll(); 
    } 
      
    public User getUserById(Long id) { 
        return userDetailsRepository.findById(id).orElse(null); 
    } 
      
    public User createUser(User User) { 
        return userDetailsRepository.save(User); 
    } 
      
    public void deleteUser(Long id) { 
    	userDetailsRepository.deleteById(id); 
    }
    
    public User getUserByUserName(User user) {
    	List<User> userList = userDetailsRepository.findAll();
		User currentUser = userList.stream().filter(e -> e.getUserName().hashCode() == user.getUserName().hashCode()).findFirst().orElse(null);
		return currentUser;
    }
    
    public User getUserByUserName(String email) {
    	List<User> userList = userDetailsRepository.findAll();
		User currentUser = userList.stream().filter(e -> e.getUserName().hashCode() == email.hashCode()).findFirst().orElse(null);
		return currentUser;
    }
}
