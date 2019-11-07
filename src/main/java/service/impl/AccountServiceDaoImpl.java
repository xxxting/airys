package service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.prototype.IAccountDao;
import entity.Account;
import service.prototype.IAccountService;
import util.Pager;
/**
 * 单元测试：
 * 	   黑盒测试（功能型测试）：比如页面有登陆按钮，测试按钮，下订单，支付按钮
 *                             人工测试也可以用工具
 * 	   白盒测试：
 *          单元测试就是白盒测试，测试内部的逻辑代码有什么问题，所有的逻辑代码都要测试
 *          
 *          
 *   单元测试：
 *   	1.引入单元测试框架junit;
 * @author 何晓庭
 *
 */
@Service
public class AccountServiceDaoImpl implements IAccountService{
	@Autowired
	private IAccountDao actDao;
	@Override
	public void transfer(Account from, Account to, double money) {
		
	}

	@Override
	public Account searchAccount(int id) {
		return actDao.find(id);
	}
	@Override
	public List<Account> listAccount(int page, int pageSize) {
		
		return null;
	}

	@Override
	public List<Account> listPaged(int pageNo, int pageSize) {
	
		return 	actDao.find((pageNo-1)*pageSize,pageSize);
	}

	@Override
	public void add() {
		// TODO Auto-generated method stub
		int n=1;
		int m=2;
	}
	
	
}