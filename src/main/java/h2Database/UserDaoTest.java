package h2Database;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
public class UserDaoTest {
	private EmbeddedDatabase db;
	UserService userService;

	@Before
	public void setUp() {
		//db = new EmbeddedDatabaseBuilder().addDefaultScripts().build();
		db = new EmbeddedDatabaseBuilder()
				.setType(EmbeddedDatabaseType.H2)
				.addScript("db/sql/create-db.sql")
				.addScript("db/sql/insert-data.sql")
				.build();
	}

//	@Test
//	public void testFindByname() {
//		NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(db);
//		UserDaoImpl userDao = new UserDaoImpl();
//		userService.setNamedParameterJdbcTemplate(template);
//
//		User user = userDao.findByName("zshi");
//
//		Assert.assertNotNull(user);
//		Assert.assertEquals(1, user.getId().intValue());
//		Assert.assertEquals("zshi", user.getName());
//		Assert.assertEquals("zheshijay@gmail.com", user.getEmail());
//
//	}

	@After
	public void tearDown() {
		db.shutdown();
	}
}
