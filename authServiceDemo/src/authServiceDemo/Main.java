package authServiceDemo;

import authServiceDemo.business.abstracts.AuthService;
import authServiceDemo.business.abstracts.UserService;
import authServiceDemo.business.concretes.AuthManager;
import authServiceDemo.business.concretes.UserManager;
import authServiceDemo.core.GoogleAdapter;
import authServiceDemo.dataAccess.concretes.HibernateUserDao;
import authServiceDemo.entities.concretes.User;
import authServiceDemo.googleAuthSystem.GoogleAuthSystemManager;

public class Main {

	public static void main(String[] args) {
		
		
		AuthService authService = new AuthManager(new UserManager(new HibernateUserDao()),new GoogleAdapter());
		UserService userService = new UserManager(new HibernateUserDao());
;	    
		User user = new User(2,"Baris","Tan","kemal@baris.com","123456");
		//User user1 = new User(1,"batu","altan","batu@batu.com","123456");
		//userService.add(user);
		authService.register(user);
		
		authService.login(user);
		
		
		
	}

}
