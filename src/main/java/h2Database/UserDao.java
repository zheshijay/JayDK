package h2Database;

public interface UserDao {
	void save(User user);
	void update(User user);
	void delete(User user);
	User findByUserId(String userId);
}
