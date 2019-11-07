package dao.prototype;

import java.util.List;

import entity.Account;
import util.Pager;

public interface IAccountDao {
	void saveOrUpdate(Account act);	
	public abstract Account find(int id);
	
	List<Account> find(int offset,int pageSize);
	
	int totlalItems();
	
	int totalItems();
	Pager<Account> findPaged(int offset, int pageSize) ;
	
	void delete(int id);
	void add() ;
}
