package com.example.demo.Services;

import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.demo.Bean.Product;
import com.example.demo.Entity.UserDetails;
import com.example.demo.Repository.UserRepository;


@Service
public class UserServicesImpl implements UserServices{
	
	@Autowired
	private UserRepository userrepo;
	
	private final RestTemplate restTemplate;
	
	@Autowired
    public UserServicesImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

	@Override
	public String saveuser(UserDetails user) {
		String res="Failure";
		if (user!=null) {
			user.setCreatedOn(new Date());
			user.setDeletedFlag(0);
			
			userrepo.save(user);
			res="Success";
		}
	
		return res;
	}

	@Override
	public String authenticate(String userName, String password) {
		String result = "User Not Found";
		Optional<UserDetails> user = userrepo.getUserDetailsByUserName(userName);
		if (user.isPresent()) {
			UserDetails userdetails=user.get();
			if (userdetails.getPassword().endsWith(password)) {
				result="Authntication Successfully";
			}
			else
			{
				result="PassWord Not Matched";
			}
		}
		return result;
	}

	@Override
	public UserDetails getUserById(long userId) {
		UserDetails user=userrepo.getById(userId);
		
		return user;
	}
	 public List<Product> getProductsByUserId(long userId) {
	        String url = "http://localhost:8081/products/user/" + userId;
	        
	        try {
	        	  ResponseEntity<List<Product>> response = restTemplate.exchange(
	      	            url,
	      	            HttpMethod.GET,
	      	            null,
	      	            new ParameterizedTypeReference<List<Product>>() {}
	      	        );
	        	  return response.getBody();
			} catch (Exception e) {
				 System.err.println("HTTP error occurred: " + e.getMessage());
			        return Collections.emptyList();
			}
	      
	        
	       
	        
	        
	        
	       
	    }
	
}
