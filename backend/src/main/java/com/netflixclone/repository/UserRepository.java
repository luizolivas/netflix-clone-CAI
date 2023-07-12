package com.netflixclone.repository;

import java.util.ArrayList;

import com.netflixclone.entities.User;

public class UserRepository {
	private static UserRepository instance;
	private ArrayList<User> users;

	private UserRepository() {
		users = new ArrayList<>();
		User user1 = new User(1, "Luiz", 21, "luiz@email.com","luiz123");
		User user2 = new User(2, "Fulano", 17, "fulano@email.com","fulano123");
		User user3 = new User(3, "Cicrano", 25, "cicrano@email.com","cicrano123");

		users.add(user1);
		users.add(user2);
		users.add(user3);
	}

	public static UserRepository getInstance() {
		if (instance == null) {
			synchronized (UserRepository.class) {
				if (instance == null) {
					instance = new UserRepository();
				}
			}
		}
		return instance;
	}

	public ArrayList<User> getUsers() {
		return users;
	}
}
