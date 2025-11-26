package first_java_project.ems_backend.service;

import first_java_project.ems_backend.Mapper.EmployeeMapper;
import first_java_project.ems_backend.dto.EmployeeDto;
import first_java_project.ems_backend.entity.Employee;
import first_java_project.ems_backend.exception.ResourceNotFoundException;
import first_java_project.ems_backend.repository.Employee_Repository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor

public class EmployeeServiceimpl implements EmployeeService{

    private Employee_Repository EmployeeRepository;

    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {
        Employee employee = EmployeeMapper.mapToEmployee(employeeDto);
        Employee createEmployee = EmployeeRepository.save(employee);
        return EmployeeMapper.mapToEmployeeDto(createEmployee);
    }

    @Override
    public EmployeeDto getEmployeeById(Long employeeId) {
        Employee employee =EmployeeRepository.findById(employeeId)
                .orElseThrow(()-> new ResourceNotFoundException("Employee is not exists with given Id: "+ employeeId));

        return EmployeeMapper.mapToEmployeeDto(employee);
    }


    @Override
    public List<EmployeeDto> getAllEmployee() {
        List<Employee>employees = EmployeeRepository.findAll();

        return employees.stream().map((employee) -> EmployeeMapper.mapToEmployeeDto(employee)).collect(Collectors.toList());
    }

    @Override
    public EmployeeDto updateEmployee(Long employeeId, EmployeeDto updateEmployee) {

        Employee employee = EmployeeRepository.findById(employeeId).orElseThrow(()
                -> new ResourceNotFoundException("Employee in not exists with given Id: " + employeeId));
        employee.setFirstName(updateEmployee.getFirstName());
        employee.setLastName(updateEmployee.getLastName());
        employee.setEmail(updateEmployee.getEmail());

        Employee updatedEmployee =EmployeeRepository.save(employee);
        return EmployeeMapper.mapToEmployeeDto(updatedEmployee);

    }

    @Override
    public void deleteEmployee(Long employeeId) {
        Employee employee = EmployeeRepository.findById(employeeId).orElseThrow(()
                -> new ResourceNotFoundException("Employee in not exists with given Id: " + employeeId));

        EmployeeRepository.deleteById(employeeId);
    }
}
