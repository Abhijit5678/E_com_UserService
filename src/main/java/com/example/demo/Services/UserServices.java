package com.example.demo.Services;

import java.util.List;

import com.example.demo.Bean.Product;
import com.example.demo.Entity.UserDetails;

public interface UserServices {

	String saveuser(UserDetails user);

	String authenticate(String userName, String password);

	UserDetails getUserById(long userId);

	List<Product> getProductsByUserId(long userId);
	

}
