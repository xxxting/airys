package ServiceTest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import config.AppConfig;
import dao.prototype.IAccountDao;
import service.prototype.IAccountService;
import util.Pager;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes= {AppConfig.class})
public class AccountServiceTest {
	
	@Autowired
	private IAccountService actService;
	
	@Autowired
	private IAccountDao actDao;
	@Test
	public void testsearch() {
		
		System.out.println(((Pager)actService.listPaged(1,1)).getData());                
	}
                                                            
	@Test
	public void test() {
		System.out.println(actService.searchAccount(2));
	}
	
	@Test
	public void test2() {
		System.out.println(actDao.find(0, 1));
	}
}
