package com.rajeshkawali.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rajeshkawali.model.User;
import com.rajeshkawali.service.UserService;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Rajesh_Kawali
 *
 */
@Slf4j
@RestController
@RequestMapping("/api")
public class UserController {

	public static final String CLASS_NAME = UserController.class.getName();

	@Autowired
	private UserService userService;

	@GetMapping("/user/{id}")
	@Cacheable(value = "users", key = "#id") //, unless = "#result.id<3"
	public User getUser(@PathVariable long id) {
		String _function = ".getUser()";
		log.info(CLASS_NAME + _function + "::ENTER");
		log.debug(CLASS_NAME + _function + "::id: {}", id);
		return userService.getUser(id);

	}

	@PostMapping("/user")
	public User create(@RequestBody User user) {
		String _function = ".create()";
		log.info(CLASS_NAME + _function + "::ENTER");
		log.debug(CLASS_NAME + _function + "::user: {}", user.toString());
		return userService.create(user);
	}

	@GetMapping("/users")
	public List<User> getAllUsers() {
		String _function = ".getAllUsers()";
		log.info(CLASS_NAME + _function + "::ENTER");
		return userService.getAllUsers();
	}

	@PutMapping("/update")
	@CachePut(value = "users", key = "#user.id")
	public User updateUser(@RequestBody User user) {
		String _function = ".updateUser()";
		log.info(CLASS_NAME + _function + "::ENTER");
		log.debug(CLASS_NAME + _function + "::update: {}", user.toString());
		return userService.update(user);
	}

	@DeleteMapping("/delete/{id}")
	@CacheEvict(value = "users", allEntries = false, key = "#id")
	public void deleteUser(@PathVariable Long id) {
		String _function = ".deleteUser()";
		log.info(CLASS_NAME + _function + "::ENTER");
		log.debug(CLASS_NAME + _function + "::delete: {}", id);
		userService.delete(id);
		log.debug(CLASS_NAME + _function + "::User deleted: id: {}", id);
	}
}
