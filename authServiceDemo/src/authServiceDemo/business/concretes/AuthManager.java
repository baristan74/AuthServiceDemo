package authServiceDemo.business.concretes;

import authServiceDemo.business.abstracts.AuthService;
import authServiceDemo.business.abstracts.UserService;
import authServiceDemo.core.LoggerService;
import authServiceDemo.entities.concretes.User;

public class AuthManager implements AuthService {

	private UserService userService;
	private LoggerService loggerService;

	public AuthManager(UserService userService, LoggerService loggerService) {
		this.loggerService = loggerService;
		this.userService = userService;
	}

	@Override
	public boolean register(User user) {
		if (!(this.userService.checkEmailIsCorrect(user.getEmail()))) {
			return false;
		}
		if (!((user.getFirtName().length() >= 2) || (user.getLastName().length() >= 2))) {
			System.out.println("isim veya soyisim 2 karakterden k���k olamaz");
			return false;
		}
		if (!(user.getPassword().length() >= 6)) {
			System.out.println("parola 6 karakterden b�y�k olmal�");
			return false;
		}

		System.out.println("Mesaj g�nderildi");
		System.out.println("Hesab�n�z olu�turuldu");
		this.userService.add(user);
		return true;

	}

	@Override
	public boolean login(User user) {
		User userEmailExists = userService.getByEmail(user.getEmail());
		if (userEmailExists == null) {
			System.out.println("Kullan�c� bulunamad�");
			return false;
		}
		if (!user.getPassword().equals(userEmailExists.getPassword())) {
			System.out.println("Mail yada parola yanl��");
			return false;
		}
		System.out.println("Giri� yap�ld�");
		this.loggerService.login(user);
		return true;
	}

}
