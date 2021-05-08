package authServiceDemo.business.abstracts;

import java.util.List;

import authServiceDemo.entities.concretes.User;

public interface UserService {

	void add(User user);

	void delete(User user);

	User get(int id);

	List<User> getAll();

	boolean checkEmailIsCorrect(String email);

	User getByEmail(String email);

	boolean isVerified(User user);
}
