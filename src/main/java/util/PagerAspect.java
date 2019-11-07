package util;

import java.lang.reflect.Method;
import java.util.List;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class PagerAspect {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Pointcut("execution(* service..*(..))")   //检测srevice包以及子包中的所有方法
	public void pointCut() {}
	
	@Around("pointCut()")
	public Object around(ProceedingJoinPoint jp) {
		Object o =null;
		
		MethodSignature signature = (MethodSignature)jp.getSignature();
		Method m = signature.getMethod();
		MiniPager miniPager = (MiniPager)m.getAnnotation(MiniPager.class);
		
		if(miniPager==null) {
			try {
				jp.proceed();
			} catch (Throwable e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return o;
			
		}
		
		//-- 4.若加有@MiniPager标注，则加入分页代码
				//-- i.获取某实体类对应的总的条目数
				String tableName = miniPager.tableName();
				int totalItems = jdbcTemplate.queryForObject(
						"select count(*) from "+tableName,
						Integer.class);
				//-- ii. 根据页大小计算的总的页数
				int pageSize = (Integer)jp.getArgs()[1];
				int pageNo = (Integer)jp.getArgs()[0];
				int totalPages = (totalItems + pageSize -1)/pageSize;
				if(pageNo>=totalPages)pageNo = totalPages;
				//-- iii. 返回Pager对象
				Pager pager = new Pager();
				List data=null;
				try {
					data = (List)jp.proceed(new Object[]{pageNo,pageSize});
					
					pager.setData(data);
					pager.setTotal(totalPages);
				} catch (Throwable e) {
					e.printStackTrace();
				}
				return o;
				
				
	}
}
