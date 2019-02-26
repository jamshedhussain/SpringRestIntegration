package com.itz.service;

import com.itz.model.User;


public interface UserService {

	public boolean add(User user);

	public User get(String uid);

}
