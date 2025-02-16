package com.airtribe.employee.service;

import com.airtribe.employee.entity.Employee;
import com.airtribe.employee.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@CacheConfig(cacheNames = "employees")
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Cacheable
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @CacheEvict(allEntries = true)
    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Cacheable(value = "employees", key = "#id")
    public Optional<Employee> getEmployeeById(Long id) {
        return employeeRepository.findById(id);
    }
}
