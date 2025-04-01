package com.website.controller;

import java.util.List;
import java.util.Map;

import com.website.service.userService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.website.entity.TypeEntity;
import com.website.entity.UserEntity;

@RestController
@RequestMapping("/users")
@CrossOrigin(origins = "*")
public class userController {
	@Autowired
	private userService userService;

	@GetMapping
	public List<UserEntity> getAllUsers() {
		return userService.getAllUsers();
	}

	@PostMapping("/search")
	public List<UserEntity> getByUserDetails(@RequestBody Map<String, String> request) {
		String username = request.get("field"); // Extracting "field" from request body
		return userService.getByUserDetails(username);
	}

	@GetMapping("/{id}")
	public UserEntity getUserById(@PathVariable Long id) {
		return userService.getUserById(id);
	}

	@PostMapping
	public UserEntity createUser(@RequestBody UserEntity user) {
		return userService.createUser(user);
	}

	@PutMapping("/{id}")
	public UserEntity updateUser(@PathVariable Long id, @RequestBody UserEntity user) {
		return userService.updateUser(id, user);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteUser(@PathVariable Long id) {
		userService.deleteUser(id);
		 return ResponseEntity.ok("User deleted successfully!");
	}
	@GetMapping("/getAllEntities")
	public List<TypeEntity> getAllEntities() {
		return userService.getAllEntities();
	}

}
