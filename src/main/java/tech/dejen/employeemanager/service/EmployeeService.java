package tech.dejen.employeemanager.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.dejen.employeemanager.model.Employee;
import tech.dejen.employeemanager.repo.EmployeeRepo;
import tech.dejen.employeemanager.exception.UserNotFoundException;

import java.util.List;
import java.util.UUID;

@Service
public class EmployeeService {
    private final EmployeeRepo employeeRepo;

    @Autowired
    public EmployeeService(EmployeeRepo employeeRepo) {
        this.employeeRepo = employeeRepo;
    }

   public Employee addEmployee(Employee employee) {
     employee.setEmployeeCode(UUID.randomUUID().toString());
     return employeeRepo.save(employee);
   }

   public List<Employee> findAllEmployees() {
        return employeeRepo.findAll();
   }

   public Employee updateEmployee(Employee employee) {
        return employeeRepo.save(employee);
   }

    public Employee findEmployeeById(Long id) {
        return employeeRepo.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User by id " + id + " was not found"));
    }

    public void deleteEmployee(Long id) {
        employeeRepo.deleteById(id);
   }
}
