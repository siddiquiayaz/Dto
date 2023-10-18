package com.demo.controler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.Dto.UserDto;
import com.demo.Entity.User;
import com.demo.converter.UserConverter;
import com.demo.repo.UserRepo;

@RestController
@RequestMapping("/user")
public class UserContr {
	
	 @Autowired
	  UserRepo userRepo;
	 @Autowired
	 UserConverter userConverter;
	             @GetMapping("/getall")
	    public List<UserDto> findAll(){
	    	List<User> user =userRepo.findAll();
			return  userConverter.entityToDto(user);
	
	    }   
	      @PostMapping ("/save")
	   public  UserDto save (@RequestBody UserDto userDto) {
		   
		   User user =userConverter.dtoToEntity(userDto);
		    user =userRepo.save(user);
		return userConverter.enitityToDto(user);
		      
		  
		   
	    	
	    }
	    
	     

}
