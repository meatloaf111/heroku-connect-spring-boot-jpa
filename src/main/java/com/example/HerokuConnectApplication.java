package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.*;
import java.sql.*;
import java.io.*;
import java.util.*;
import java.net.URISyntaxException;
import java.net.URI;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.example.dao.EmployeeDao;
import com.example.model.Employee;
import org.springframework.context.annotation.ImportResource;


@Controller
@SpringBootApplication
@EnableAutoConfiguration
@ImportResource("classpath:applicationContext.xml")
public class HerokuConnectApplication {
    @Autowired
    static EmployeeDao employeeDao;

    @RequestMapping("/")
    public String home(Model model) {
        return "home";
    }

	/*@RequestMapping("/contacts")
    public String contacts(Model model) {
        try {
            Connection connection = getConnection();
            Statement stmt = connection.createStatement();
            String sql;
            sql = "SELECT id, sfid,  firstname, lastname, name, email FROM salesforce.contact";
            ResultSet rs = stmt.executeQuery(sql);
            StringBuffer sb = new StringBuffer();
            List contacts = new ArrayList<>();
            // Extract data from result set
            while (rs.next()) {
                int id = rs.getInt("id");
                String sfid = rs.getString("sfid");
                String name = rs.getString("name");
                String first = rs.getString("firstname");
                String last = rs.getString("lastname");
                String email = rs.getString("email");
                contacts.add(new Contact(id, sfid, first, last, email));
            }
            model.addAttribute("contacts", contacts);
            return "contact";
        } catch (Exception e) {
            return e.toString();
        }
    }*/

    @RequestMapping("/employee")
    public String employees(Model model) {
        try {
            EmployeeDao dao = getEmployeeDao();


            List<Employee> employees = (List<Employee>) dao.findAll();
            /*for (Person person : persons) {
                System.out.println(person);
            }
            List contacts = new ArrayList<>();
            // Extract data from result set
            while (rs.next()) {
                int id = rs.getInt("id");
                String sfid = rs.getString("sfid");
                String name = rs.getString("name");
                String first = rs.getString("firstname");
                String last = rs.getString("lastname");
                String email = rs.getString("email");
                contacts.add(new Contact(id, sfid, first, last, email));
            }*/
            model.addAttribute("employees", employees);
            return "employee";
        } catch (Exception e) {
            return e.toString();
        }
    }

    private static Connection getConnection() throws URISyntaxException, SQLException {
		URI dbUri = new URI(System.getenv("DATABASE_URL"));

		String username = dbUri.getUserInfo().split(":")[0];
		String password = dbUri.getUserInfo().split(":")[1];
		String dbUrl = "jdbc:postgresql://" + dbUri.getHost() + ':'
                + dbUri.getPort() + dbUri.getPath()
                + "?sslmode=require";

		return DriverManager.getConnection(dbUrl, username, password);
	}

    private static EmployeeDao getEmployeeDao() {
        //ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
        //        "applicationContext.xml");
        //EmployeeDao dao = context.getBean(EmployeeDao.class);
        return employeeDao;
    }

	public static void main(String[] args) {
		SpringApplication.run(HerokuConnectApplication.class, args);
	}
}