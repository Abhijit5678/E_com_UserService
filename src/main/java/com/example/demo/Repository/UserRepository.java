package com.example.demo.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.Entity.UserDetails;
@Repository
public interface UserRepository extends JpaRepository<UserDetails, Long>{
	@Query(nativeQuery = true, value = "SELECT * FROM user_details where user_name=?1")
	Optional<UserDetails> getUserDetailsByUserName(String userName);
	@Query(nativeQuery = true, value = "SELECT * FROM user_details where user_id=?1")
	UserDetails getUserByUserId1(long userId);

}
