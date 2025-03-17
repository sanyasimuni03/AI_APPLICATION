package com.user.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.user.DTO.UserResponse;
import com.user.Entity.User;
import com.user.Exception.ResourceNotFoundException;
import com.user.Repository.UserRepository;

@Service
public class UserServiceImpl  implements UserService{

	@Autowired
	private UserRepository repo;
	
	@Autowired
	private ModelMapper mapper;
	
	
	
	
	@Override
	public UserResponse CreateUser(UserResponse response) {
		
		     User user=this.mapper.map(response, User.class);
		     user.setTime(LocalDateTime.now());
		     
		        User service=  repo.save(user);
		
		return this.mapper.map(service, UserResponse.class);
	}

	@Override
	public UserResponse updateUser(Integer userId, UserResponse response) {

	    User user=this.repo.findById(userId).orElseThrow(()->new ResourceNotFoundException("User Id Not Found Exception!"));
	    
	       user.setEmail(response.getEmail());
	       user.setFirstName(response.getFirstName());
	       user.setLastName(response.getLastName());
	       user.setPassword(response.getPassword());
	       user.setPhoneNumber(response.getPhoneNumber());
	       user.setTime(response.getTime());
	     
	       
	              User saved= repo.save(user);
		
		return this.mapper.map(saved, UserResponse.class);
	}

	@Override
	public void DeleteUser(Integer userId) {
		
		    User user=this.repo.findById(userId).orElseThrow(()->new ResourceNotFoundException("User Id Not Found Exception!"));
		    
		        repo.delete(user);
	
		
	}

	@Override
	public UserResponse singleUser(Integer userId) {
		
		     User user=this.repo.findById(userId).orElseThrow(()->new ResourceNotFoundException("User Id Not Found Exception!"));
		       
		      
		return this.mapper.map(user, UserResponse.class);
	}

	@Override
	public List<UserResponse> list() {
		
		    List<User>user=this.repo.findAll();
		    List<UserResponse>userDto=user.stream().map((err)->this.mapper.map(err, UserResponse.class)).collect(Collectors.toList());
		
		
		return userDto;
	}
	
	public User userToDto(UserResponse response) {
		return this.mapper.map(response, User.class);
	}

	
	public UserResponse DtoToResponse(User response) {
		return this.mapper.map(response, UserResponse.class);
	}

}
