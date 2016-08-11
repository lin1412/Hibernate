package simoncomputing.app.myapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import simoncomputing.app.myapp.model.entity.User;
import simoncomputing.app.myapp.service.UserService;

@RestController
@RequestMapping("user/")
public class UserRestController {

	@Autowired
	private UserService userService;
	
	/* returns a list of users */
	@RequestMapping(method = RequestMethod.GET, value = "/all-users")
	public ResponseEntity<List<User>> allUsers() {

		List<User> users = userService.getAllUsers();

		return new ResponseEntity<List<User>>(users, HttpStatus.OK);
	}

	/* returns a user with id */
	@RequestMapping(method = RequestMethod.GET, value = "/user/{userId}")
	public ResponseEntity<User> getUser(@PathVariable Long userId) {
		
		User user = userService.getUser(userId);

		return user == null ? new ResponseEntity<User>(HttpStatus.NOT_FOUND)
				: new ResponseEntity<User>(user, HttpStatus.OK);
	}

	/* creates a user from json */
	@RequestMapping(method = RequestMethod.POST, value = "/user/add-user")
	public ResponseEntity<User> createUser(@RequestBody User user) {

		userService.save(user);

		return new ResponseEntity<User>(user, HttpStatus.OK);
	}
	
	/* update a user from json */
	@RequestMapping(method = RequestMethod.PUT, value = "/user/update-user")
	public ResponseEntity<User> updateUser(@RequestBody User user) {

		userService.save(user);

		return new ResponseEntity<User>(user, HttpStatus.OK);
	}

	/* deletes a user with id */
	@RequestMapping(method = RequestMethod.DELETE, value = "/user/delete/{userId}")
	public ResponseEntity<User> deleteUser(@PathVariable Long userId) {

		User user = userService.getUser(userId);

		if (user == null) {
			return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
		} else {
			userService.deleteUser(userId);
			return new ResponseEntity<User>(user, HttpStatus.OK);
		}

	}
}