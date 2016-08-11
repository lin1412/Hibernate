package simoncomputing.app.myapp.service;

import java.util.List;

import simoncomputing.app.myapp.model.entity.User;

public interface UserService {

	public User save(User user);

	public User getUser(Long userId);

	public void deleteUser(Long userId);
	
	public List<User> getAllUsers();
}