package com.itz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.itz.model.User;
import com.itz.service.UserService;

@RestController
public class UserRestController {
	@Autowired(required=true)
	private UserService service;
	
	
	@RequestMapping(value="/add",method=RequestMethod.POST,consumes= {"application/xml","application/json"})
	public @ResponseBody String addUser(@RequestBody User user) {
		boolean isAdded=service.add(user);
		if(isAdded) {
			return "user Added Successfully";
		}//if
		else {
			return "Failed to Add the User";
		}//else	
	}//addUser()
	
	@RequestMapping(value="/get",method=RequestMethod.GET,produces= {"application/xml","application/json"})
	@ResponseBody
	public User getUserById(@RequestParam(name="uid")String uid) {
		System.out.println("Getting User with User ID:"+uid);
		User user=service.get(uid);
		return user;
	}//get
}
