package com.example.demo.Bean;



import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Product {
	private long productId;
	private String productname;
	private String imagePath;
	private Double price;
	private long userId;
	
	
}

