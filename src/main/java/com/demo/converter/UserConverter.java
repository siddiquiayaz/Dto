package com.demo.converter;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.demo.Dto.UserDto;
import com.demo.Entity.User;

@Component
public class UserConverter {

	public UserDto enitityToDto(User user) {
		UserDto dto = new UserDto();
		dto.setId(user.getId());
		dto.setName(user.getName());
		dto.setUserName(user.getUserName());
		dto.setPassword(user.getPassword());
		return dto;

	}

	public List<UserDto> entityToDto(List<User> user) {
		return user.stream().map(m -> enitityToDto(m)).collect(Collectors.toList());
	}

	public User dtoToEntity(UserDto dto) {

		User user = new User();
		user.setId(dto.getId());
		user.setName(dto.getName());
		user.setUserName(dto.getUserName());
		user.setPassword(dto.getPassword());
		return user;

	}

	public List<User> dtoToEntity(List<UserDto> dto) {
		return dto.stream().map(m -> dtoToEntity(m)).collect(Collectors.toList());
	}

}
