package com.itz.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.itz.model.User;

@Service(value="service")
public class UserServiceImpl implements UserService {

	private static Map<Integer, User> userData = new HashMap<Integer, User>();

	public boolean add(User user) {
		if (userData.containsKey(user.getUserid())) {
			return false;
		} // if
		else {
			userData.put(user.getUserid(), user);
			return true;
		} // else
	}// add()

	public User get(String uid) {
		System.out.println(userData);
		if (userData.containsKey(Integer.parseInt(uid))) {
			return userData.get(Integer.parseInt(uid));
		}
		return null;
	}// get()
	

}// class
