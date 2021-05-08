package authServiceDemo.dataAccess.abstracts;



import java.util.List;

import authServiceDemo.entities.concretes.User;

public interface UserDao {
	
	void add(User user);
	void delete(User user);
	List<User> getAll();
	User getByEmail(String email);
	boolean isVerified(User user);
	User get(int id);
	

}
