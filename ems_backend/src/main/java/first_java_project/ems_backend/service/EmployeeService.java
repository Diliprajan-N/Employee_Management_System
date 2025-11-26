package first_java_project.ems_backend.service;

import first_java_project.ems_backend.dto.EmployeeDto;

import java.util.List;


public interface EmployeeService {
    EmployeeDto createEmployee(EmployeeDto employeeDto);

    EmployeeDto getEmployeeById(Long employeeId);

    List<EmployeeDto> getAllEmployee();

    EmployeeDto updateEmployee(Long employee, EmployeeDto updateEmployee);

    void deleteEmployee(Long employeeId);


}

