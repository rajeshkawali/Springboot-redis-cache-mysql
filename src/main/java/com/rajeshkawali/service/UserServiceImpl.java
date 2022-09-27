package com.rajeshkawali.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rajeshkawali.model.User;
import com.rajeshkawali.repository.UserRepository;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Rajesh_Kawali
 *
 */
@Slf4j
@Service
public class UserServiceImpl implements UserService {

	public static final String CLASS_NAME = UserServiceImpl.class.getName();

	@Autowired
	private UserRepository userRepository;

	@Override
	public User getUser(long id) {
		String _function = ".getUser()";
		log.debug(CLASS_NAME + _function + "::ENTER");
		Optional<User> userOp = userRepository.findById(id);
		if (userOp != null) {
			log.debug(CLASS_NAME + _function + "::User Exists");
			return userOp.get();
		} else {
			log.debug(CLASS_NAME + _function + "::No User Exists");
			return null;
		}
	}
	
	@Override
	public User create(User user) {
		String _function = ".create()";
		log.debug(CLASS_NAME + _function + "::ENTER");
		User userToRet = userRepository.save(user);
		log.debug(CLASS_NAME + _function + "::EXIT");
		return userToRet;
	}

	@Override
	public List<User> getAllUsers() {
		String _function = ".getAllUsers()";
		log.debug(CLASS_NAME + _function + "::ENTER");
		return userRepository.findAll();
	}

	@Override
	public void delete(long id) {
		String _function = ".delete()";
		log.debug(CLASS_NAME + _function + "::ENTER");
		userRepository.deleteById(id);
	}

	@Override
	public User update(User user) {
		String _function = ".update()";
		log.debug(CLASS_NAME + _function + "::ENTER");
		Long id = user.getId();
		User userInDb = getUser(id);
		if (userInDb != null) {
			log.debug(CLASS_NAME + _function + "::User updated");
			return create(user);
		} else {
			log.debug(CLASS_NAME + _function + "::User does not exist");
			return null;
		}
	}
}
