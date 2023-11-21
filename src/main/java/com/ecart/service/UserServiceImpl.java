package com.ecart.service;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecart.repository.UserRepository;
import com.ecart.repository.models.User;
/**
 * Class that provides the services that are related to User.
 */
@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userRepo;
	
	@Override
	public void saveUser(User user) {
		// TODO Auto-generated method stub
		
		System.out.println("User saved successfully..!"+
		user.getFirst_name()+"\n");
		user.setRegistration_date(new Timestamp(System.currentTimeMillis()));
		userRepo.save(user);
		
	}

	@Override
	public User findByEmailAndPassword(String email, String password) {
		// TODO Auto-generated method stub
		User userFetched=userRepo.findByEmailAndPassword(email, password);
		if(userFetched!=null) {
			System.out.println("User exists");
		}else {
			List<User> users= userRepo.findAll();
			for(User u: users) {
				System.out.println("user with:"+u.getEmail()+" "+u.getPassword());
			}
			System.out.println("No user with:"+email+" "+password);
		}
		return userFetched;
	}

}
