package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.UrlBasedViewResolver;

@Configuration
@ComponentScan({"dao","service","util"})
@Import(DBConfig.class)
@EnableAspectJAutoProxy
public class AppConfig extends WebMvcConfigurationSupport{
	/**
	 *jsp的解析器
	 *这个Bean的作用就是告诉Spring  MVC你写的JSP文件的位置 
	 */
	@Bean
	public  UrlBasedViewResolver setupViewResolver() {
		UrlBasedViewResolver resolver = new UrlBasedViewResolver();
		resolver.setPrefix("/WEB-INF/");     // 位置   受保护的，不可以直接访问
		resolver.setSuffix(".jsp");                //jsp文件的后缀   你在写页面的时候就省略掉后缀
		resolver.setViewClass(JstlView.class);
		return resolver;
	}
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/assets/**").addResourceLocations("/assets/");
		
		super.addResourceHandlers(registry);
	}
}