package com.website.service;

import java.util.List;

import com.website.Repo.TypeRepository;
import com.website.Repo.UserRepository;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.website.entity.TypeEntity;
import com.website.entity.UserEntity;

import jakarta.persistence.EntityNotFoundException;

@Service
public class userService {
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private TypeRepository typeRepository;

	public List<UserEntity> getAllUsers() {
		return userRepository.findAll();
	}

	public UserEntity getUserById(Long id) {
		return userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found with ID: " + id));
	}

	public UserEntity createUser(UserEntity user) {
		return userRepository.save(user);
	}

//    public User updateUser(Long id, User user) {
//        User existingUser = getUserById(id);
//        existingUser.setUsername(user.getUsername());
//        existingUser.setEmail(user.getEmail());
//        return userRepository.save(existingUser);
//    }
	public UserEntity updateUser(Long id, UserEntity user) {
		UserEntity existingUser = userRepository.findById(id).get();

		if (existingUser != null) { // Ensure the user exists before updating
			existingUser.setUsername(user.getUsername());
			existingUser.setEmail(user.getEmail());
			return userRepository.save(existingUser); // Save the updated entity
		} else {
			throw new EntityNotFoundException("User not found with ID: " + id);
		}
	}

	public void deleteUser(Long id) {
		userRepository.deleteById(id);
	}

	public List<UserEntity> getByUserDetails(String field) {
		return userRepository.findByUsernameSearch(field);
	}

	public List<TypeEntity> getAllEntities() {

		return typeRepository.findAll();
	}
}
