package simoncomputing.app.myapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import simoncomputing.app.myapp.model.entity.User;
import simoncomputing.app.myapp.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;

	@Override
	public User save(User user) {
		return userRepository.save(user);
	}

	@Override
	public User getUser(Long userId) {

		return userRepository.findOneByUserId(userId);
	}

	@Override
	public void deleteUser(Long userId) {

		userRepository.delete(userId);
	}

	@Override
	public List<User> getAllUsers() {

		return userRepository.findAll();
	}

}
