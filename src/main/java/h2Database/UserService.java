package h2Database;

public class UserService {
	UserDao userDao;
	
	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	
	public void saveUser(User user){
		userDao.save(user);
	}
}
