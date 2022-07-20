package com.example.springdata.service;

import com.example.springdata.model.Employee;
import com.example.springdata.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public Iterable<Employee> getAllEmployees(){
        return employeeRepository.findAll();
    }

    // id yə uyğun employee tapılmasa exception throw edir
    public Employee getEmployeeById(int id){
        return employeeRepository.findById(id).orElseThrow();
    }

    public void insert(Employee employee){
        employeeRepository.save(employee);
    }

    /*update methodunda 2 işlem var.bu annotation ona xidmət edir ki hər 2 işlem uğurla başa çatsa
     database-yə yazılsın.2-sindən sadecə biri uğurlu olarsa o rollback olunur.*/
    @Transactional
    public void update(Employee employee){
        Employee emp = new Employee();
        emp.setName("Resad");
        employeeRepository.save(emp);

        employeeRepository.save(employee);
    }

    public void delete(int id){
        employeeRepository.deleteById(id);
    }
}
