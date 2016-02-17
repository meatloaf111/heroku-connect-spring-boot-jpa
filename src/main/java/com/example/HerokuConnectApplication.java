package com.example;

import com.example.dao.ContactRepository;
import com.example.dao.ContactRepository;
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
import com.example.dao.EmployeeRepository;
import com.example.model.Employee;
import org.springframework.context.annotation.ImportResource;
import com.example.model.Contact;


@Controller
@SpringBootApplication
@EnableAutoConfiguration
@ImportResource("classpath:applicationContext.xml")
public class HerokuConnectApplication {
    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    ContactRepository contactRepository;

    @RequestMapping("/")
    public String home(Model model) {
        return "home";
    }

	@RequestMapping("/contacts")
    public String contacts(Model model) {
        try {
            ContactRepository repo = getContactRepository();
            List<Contact> contacts = null;

            if(repo != null) {
                contacts = (List<Contact>) repo.findAll();
                model.addAttribute("contacts", contacts);
            }
            return "contact";
        } catch (Exception e) {
            model.addAttribute("contacts", new LinkedList());
            e.printStackTrace();
        }
        return "contact";
    }

    @RequestMapping("/employee")
    public String employees(Model model) {
        try {
            EmployeeRepository repo = getEmployeeDao();
            List<Employee> employees = null;
            if(repo != null) {
                employees = (List<Employee>) repo.findAll();
                model.addAttribute("employees", employees);
            }

        } catch (Exception e) {
            model.addAttribute("employees", new LinkedList());
            e.printStackTrace();
        }
        return "employee";
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

    private EmployeeRepository getEmployeeDao() {
 ;
        return employeeRepository;
    }

    private ContactRepository getContactRepository() {

        return contactRepository;
    }

	public static void main(String[] args) {
		SpringApplication.run(HerokuConnectApplication.class, args);
	}
}
