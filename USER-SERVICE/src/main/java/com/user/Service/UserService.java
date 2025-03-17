package com.user.Service;

import java.util.List;

import com.user.DTO.UserResponse;

public interface UserService {
	
	public UserResponse CreateUser(UserResponse response);
	public UserResponse updateUser(Integer userId,UserResponse response);
	
	public void DeleteUser(Integer userId);
	
	public UserResponse singleUser(Integer userId);
	public List<UserResponse>list();

}
