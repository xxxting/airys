package service.prototype;

import java.util.List;

import entity.Account;
import util.MiniPager;
import util.Pager;

public interface IAccountService {
	//转账
	public abstract void transfer(Account from,Account to,double money);
	//查询账号
	public Account searchAccount(int id);

	//分页查询账号信息

	List<Account> listAccount(int page,int pageSize);
	@MiniPager(tableName="account")
	List<Account> listPaged(int pageNo , int pageSize);
	
	void add();
	
}