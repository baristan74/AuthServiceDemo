package authServiceDemo.dataAccess.concretes;

import java.util.ArrayList;
import java.util.List;

import authServiceDemo.dataAccess.abstracts.UserDao;
import authServiceDemo.entities.concretes.User;

public class HibernateUserDao implements UserDao {

	private List<User> users;

	public HibernateUserDao() {
		this.users = new ArrayList<>();
	}

	@Override
	public void add(User user) {
		this.users.add(user);
		// System.out.println("Kullanýcý veritabanýna eklendi");
	}

	@Override
	public void delete(User user) {
		this.users.remove(user);
		System.out.println("Kullanýcý veritabanýna eklendi");

	}

	@Override
	public User getByEmail(String email) {
		User userToReturn = null;
		for (User user : users) {
			if (user.getEmail().equals(email)) {
				userToReturn = user;
				break;
			}
		}
		return userToReturn;
	}

	@Override
	public List<User> getAll() {
		return users;

	}

	@Override
	public User get(int id) {
		User userToReturn = null;
		for (User user : users) {
			if (user.getId() == id) {
				userToReturn = user;
				break;
			}
		}
		return userToReturn;
	}

	@Override
	public boolean isVerified(User user) {
		User userToCheck = get(user.getId());
		return userToCheck.isVerify() ? true : false;
	}

}
