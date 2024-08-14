package com.example.demo.Services;

import com.example.demo.Entity.UserDetails;

public interface UserServices {

	String saveuser(UserDetails user);

	String authenticate(String userName, String password);
	

}
