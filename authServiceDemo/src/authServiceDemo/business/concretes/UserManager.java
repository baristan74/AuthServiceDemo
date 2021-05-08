package authServiceDemo.business.concretes;

import java.util.List;
import java.util.regex.Pattern;

import authServiceDemo.business.abstracts.UserService;
import authServiceDemo.dataAccess.abstracts.UserDao;
import authServiceDemo.entities.concretes.User;

public class UserManager implements UserService {

	
	private UserDao userDao;
	
	public UserManager(UserDao userDao) {  
		this.userDao = userDao;
	}

	@Override
	public void add(User user) {
		this.userDao.add(user);
		
	}

	@Override
	public void delete(User user) {
		if(!(getByEmail(user.getEmail()) != null) && isVerified(user)){
			System.out.println("Mevcut olmayan kullanýcý silinemez");
			return;
		}
		this.userDao.delete(user);
		
	}
	

	@Override
	public User get(int id) {
		return this.userDao.get(id);
		
	}

	@Override
	public List<User> getAll() {
		
		return this.userDao.getAll();
	}


	@Override
	public User getByEmail(String email) {
		
		User userFound = this.userDao.getByEmail(email);
		return userFound;
	}

	@Override
	public boolean isVerified(User user) {
		
		return this.userDao.isVerified(user);
	}

	@Override
	public boolean checkEmailIsCorrect(String email) {
		String EMAILPATTERN = "^[A-Z0-9.%+-]+@[A-Z0-9.-]+.(com|org|net|edu|gov|mil|biz|info|mobi)(.[A-Z]{2})?$";
        Pattern pattern = Pattern.compile(EMAILPATTERN,    Pattern.CASE_INSENSITIVE);
        if(!pattern.matcher(email).find()){
            System.out.println("Mail istenilen formatta deðil");
            return false;
        }
        return true;
	}
	
	

	
	
	
	
		

}
