package com.cclit.authdemo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cclit.authdemo.bean.User;

/**
 *  User Entity Repository
 *  
 *  @author GalenLin
 */
@Repository
public interface UserDao extends JpaRepository<User, String> {
	
	public User findUserByEmail(String email);

}
