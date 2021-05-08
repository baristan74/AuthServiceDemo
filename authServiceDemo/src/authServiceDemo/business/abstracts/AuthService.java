package authServiceDemo.business.abstracts;

import authServiceDemo.entities.concretes.User;

public interface AuthService {
	
	boolean register(User user);

	boolean login(User user);

}
