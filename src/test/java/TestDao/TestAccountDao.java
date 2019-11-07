package TestDao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import config.AppConfig;
import dao.prototype.IAccountDao;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes= {AppConfig.class})
public class TestAccountDao {
	@Autowired
	private IAccountDao actDao;
	
	@Test
	public void testFind() {
		actDao.delete(1);
		System.out.println("123");
	}
}