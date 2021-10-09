package com.shoestore.service;

import java.util.Set;

import org.springframework.stereotype.Service;

import com.shoestore.entity.UserRole;
import com.shoestore.entity.User;

public interface UserService {
	public void save(User user);
	public User findByUsername(String username);
	public User findByEmail(String email);
	public User createUser(User user, Set<UserRole> userRoles) throws Exception;
}
