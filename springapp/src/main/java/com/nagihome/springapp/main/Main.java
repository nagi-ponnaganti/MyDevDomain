/**
 * 
 */
package com.nagihome.springapp.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.jdbc.support.rowset.SqlRowSetMetaData;

/**
 * @author Nagi
 *
 */
public class Main {

	/**
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {

		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"com/nagihome/springapp/config/app-context.xml");

		JdbcTemplate jdbcTemplate = (JdbcTemplate) context
				.getBean("jdbcTemplate");

		System.out.println("Jdbc Template: " + jdbcTemplate);

		SqlRowSet resultSet = jdbcTemplate.queryForRowSet(
				"select * from nagihome.person");
		
		SqlRowSetMetaData resultSetMetaData = resultSet.getMetaData();

		int columnCount = resultSetMetaData.getColumnCount();

		for (int i = 1; i <= columnCount; i++) {
			System.out.println("The column name is: "
					+ resultSetMetaData.getColumnLabel(i));

		}
	}
}
