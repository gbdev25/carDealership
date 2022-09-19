package services;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import daos.UserDAO;
import daos.UserPostgres;
import models.User;

public class UserService {

	private UserDAO ud = new UserPostgres();
	private static Logger log = LogManager.getLogger(UserService.class);
	
	public List<User> getUsers(){
		return ud.retrieveUsers();
	}
	
	public User createUser(User u) {
		
		User user = ud.createUser(u);
		log.info("User: " + user + " was created.");
		return user;
	}
	public User retrieveAuth() {
		User user = ud.retrieveAuth(0);
		System.out.println("Authorization level" + user);
		return user;
		
	}
}
