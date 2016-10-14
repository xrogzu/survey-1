package survey_Component;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.fire.entites.EmployeeTemp;

public class TestDs {
	ApplicationContext ioc = new ClassPathXmlApplicationContext("spring-Context.xml");

	@Test
	public void test2() {
		new EmployeeTemp();
	}

	@Test
	public void test1() throws SQLException {
		DataSource dataSource = ioc.getBean(DataSource.class);
		System.out.println(dataSource.getConnection());
	}
}
