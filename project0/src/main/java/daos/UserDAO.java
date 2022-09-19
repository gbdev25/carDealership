package daos;

import java.util.List;

import models.User;

public interface UserDAO {

	User createUser(User u);
	User retrieveUserById(int id);
	List<User> retrieveUsers();
	User retrieveUserByUsername(String username);
	boolean updateUser(User u);
	boolean deleteUserById(int id);
	User retrieveAuth(int auth);

}
