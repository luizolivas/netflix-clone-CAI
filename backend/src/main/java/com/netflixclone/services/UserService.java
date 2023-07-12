package com.netflixclone.services;

import java.util.ArrayList;

import com.netflixclone.dtos.UserDTO;
import com.netflixclone.entities.User;
import com.netflixclone.repository.UserRepository;

public class UserService {
	private ArrayList<User> listOfUsers = UserRepository.getInstance().getUsers();

	public User findUser(UserDTO user) {
		for (User userList: listOfUsers) {
			UserDTO userListDTO = transformUserInUserDTO(userList);
			
			if(userListDTO.equals(user)) {
				return userList;
			}
		}
		
		return null;
	}
	
	public User getUserByIdToken(Integer id) {
		for (User userList: listOfUsers) {			
			if(userList.getSessionId() == id) {
				return userList;
			}
		}
		
		return null;
	}

	private UserDTO transformUserInUserDTO(User user) {
		return new UserDTO(user.getEmail(), user.getPassword());
	}
	
}
