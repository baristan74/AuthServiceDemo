package authServiceDemo.core;

import authServiceDemo.entities.concretes.User;
import authServiceDemo.googleAuthSystem.GoogleAuthSystemManager;

public class GoogleAdapter implements LoggerService{

	@Override
	public void login(User user) {
		
		GoogleAuthSystemManager manager = new GoogleAuthSystemManager();
		manager.login(user.getFirtName());
		
		
		
	}
	
	
}
