package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Bean.Product;
import com.example.demo.Entity.UserDetails;
import com.example.demo.Services.UserServices;
import com.example.demo.Utils.Response;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserServices userservices;

	@PostMapping("/saveUser")
	public ResponseEntity<?> saveUser(@RequestBody UserDetails user) {
		Response<?> response = new Response<>();
		String result = "";

		result = userservices.saveuser(user);
		if (!result.isBlank()) {
			response.setMessage("Data Saved SuccessFully");
			return ResponseEntity.ok(HttpStatus.OK);
		}

		else {
			response.setMessage("SomeThings Wents Wrong");
			return ResponseEntity.internalServerError().body(response);
		}

	}

	@PostMapping("/signIn")
	public ResponseEntity<Response<String>> signIn(@RequestBody UserDetails signInRequest) {
		String result = userservices.authenticate(signInRequest.getUserName(), signInRequest.getPassword());

		Response<String> response = new Response<>();
		if (result != null) {

			response.setData(result);
			return ResponseEntity.ok(response);
		} else {

			return ResponseEntity.badRequest().body(response);
		}
	}
	
	@GetMapping("/{userId}")
    public UserDetails getUserById(@PathVariable long userId) {
        return userservices.getUserById(userId);
    }
	
	@GetMapping("/products/{userId}")
    public ResponseEntity<Response<?>> getProductsByUserId(@PathVariable long userId) {
		Response<?> response = new Response<>();
		
		List<Product> productsByUserId = userservices.getProductsByUserId(userId);
		if (!productsByUserId.isEmpty()) {
			response.setData(productsByUserId);
			 return ResponseEntity.ok(response);
		}
		else {
			response.setMessage("SomeThings Wents Wrong");
			return ResponseEntity.internalServerError().body(response);
		}
		
		
		
		
		
       
    }
	@GetMapping("/{userId}/{product}/orders")
	public ResponseEntity<Response<?>> getOrderDetails(@PathVariable long userId,@PathVariable  long productId)
	
	{
		Response<?> response = new Response<>();
		
		
		return null;
		
	}
	

}
