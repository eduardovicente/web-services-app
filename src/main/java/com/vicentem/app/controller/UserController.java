package com.vicentem.app.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vicentem.app.exception.UserNotFoundException;
import com.vicentem.app.model.User;
import com.vicentem.app.service.UserService;

@RestController
@RequestMapping("users")
public class UserController {

	@Autowired
	UserService userService;

	@GetMapping
	public ResponseEntity<List<User>> getUsers(@RequestParam(value = "page", defaultValue = "1") int page,
			@RequestParam(value = "limit", defaultValue = "50") int limit,
			@RequestParam(value = "sort", defaultValue = "desc", required = false) String sort) {
		return new ResponseEntity<List<User>>(userService.getUsers(page, limit, sort), HttpStatus.OK);
	}

	@GetMapping(path = "/{userId}", produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<User> getUser(@PathVariable Long userId) throws UserNotFoundException {
		return new ResponseEntity<User>(userService.getUser(userId), HttpStatus.OK);
	}

	@PostMapping(consumes = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE }, produces = {
			MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<User> createUser(@Valid @RequestBody User userdetails) {
		return new ResponseEntity<User>(userService.createUser(userdetails), HttpStatus.CREATED);
	}

	@PutMapping(path = "/{userId}", consumes = { MediaType.APPLICATION_XML_VALUE,
			MediaType.APPLICATION_JSON_VALUE }, produces = { MediaType.APPLICATION_XML_VALUE,
					MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<User> updateUser(@PathVariable Long userId, @RequestBody User userdetails)
			throws UserNotFoundException {
		return new ResponseEntity<User>(userService.updateUser(userId, userdetails), HttpStatus.CREATED);
	}

	@DeleteMapping(path = "/{userId}")
	public ResponseEntity deleteUser(@PathVariable Long userId) throws UserNotFoundException {
		userService.deleteUser(userId);
		return ResponseEntity.noContent().build();
	}

}
