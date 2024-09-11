package com.example.demo.Bean;



import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Product implements Serializable{
	private long productId;
	private String productname;
	private String imagePath;
	private Double price;
	private long userId;
	
	
}

