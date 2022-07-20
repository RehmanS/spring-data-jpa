package com.example.springdata;

import com.example.springdata.model.Employee;
import com.example.springdata.repository.EmployeeRepository;
import com.example.springdata.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringDataApplication implements CommandLineRunner /* run metodunu override etmək üçün*/ {
  /* h2 embedded databasedir yəni hər hansi bir databaseyə qoşulmuruq*/


    public static void main(String[] args) {
        SpringApplication.run(SpringDataApplication.class, args);
    }

    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public void run(String... args) throws Exception {
        Employee employee = new Employee();
        employee.setName("Rehman");
        employee.setSurname("Sultanli");
        employee.setAge(20);
        employee.setSalary(300);

        //employeeService.insert(employee);
        employeeService.getAllEmployees().forEach(System.out::println);

    }
}
