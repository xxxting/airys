package config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;

import com.alibaba.druid.pool.DruidDataSource;

@Configuration
@PropertySource("classpath:jdbc.properties")//你的配置信息的位置
public class DBConfig {
	//1.配置信息
	@Value("${jdbc.driverClass}")
	private String driver;
	
	@Value("${jdbc.url}")
	private String url;
	
	@Value("${jdbc.username}")
	private String username;
	
	@Value("${jdbc.password}")
	private String password;
	
	//2.数据库连接池对象（DataSource Bean）
	@Bean(name="dataSource")
	public DataSource createDataSource() {
		DruidDataSource ds = new DruidDataSource();
		ds.setDriverClassName(driver);
		ds.setUrl(url);
		ds.setUsername(username);
		ds.setPassword(password);

		return ds;
		
	}
	
	//JdbcTemplate
	@Bean
	public JdbcTemplate creatJdbcTemplate(DataSource ds) {
		return new JdbcTemplate(ds);
	}
}