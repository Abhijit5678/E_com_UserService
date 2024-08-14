package com.example.demo.Services;

import java.util.Date;
import java.util.Optional;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.UserDetails;
import com.example.demo.Repository.UserRepository;


@Service
public class UserServicesImpl implements UserServices{
	
	@Autowired
	private UserRepository userrepo;

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
	
	
}
