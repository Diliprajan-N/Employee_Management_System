package first_java_project.ems_backend.controller;

import first_java_project.ems_backend.dto.EmployeeDto;
import first_java_project.ems_backend.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin("*")
@AllArgsConstructor
@RestController
@RequestMapping("/api/employees")

public class EmployeeController {
    private EmployeeService employeeService;

    //Build add Employee Rest api
    @PostMapping
    public ResponseEntity<EmployeeDto>createEmployee(@RequestBody EmployeeDto employeeDto){
        EmployeeDto savedEmployee =employeeService.createEmployee(employeeDto);
        return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
    }




    // Build get employee Rest api
    @GetMapping("{id}")


    public  ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable("id") Long employeeId){
        EmployeeDto employeeDto = employeeService.getEmployeeById(employeeId);
        return new ResponseEntity<>(employeeDto, HttpStatus.OK);
    }

    // Build get All employee rest api
    @GetMapping

    public ResponseEntity<List<EmployeeDto>> getAllEmployeeById(){
        List<EmployeeDto> employee = employeeService.getAllEmployee();
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }

    // Build Update Employee Rest api
    @PutMapping("{id}")

    public ResponseEntity<EmployeeDto>UpdateEmployee(@PathVariable("id") Long employeeId, @RequestBody EmployeeDto updatedEmployee){
        EmployeeDto employeeDto = employeeService.updateEmployee(employeeId, updatedEmployee);
        return new ResponseEntity<>(employeeDto, HttpStatus.OK);
    }

    // Build delete Employee Test api

    @DeleteMapping("{id}")

   public ResponseEntity<String> deleteEmployee(@PathVariable("id") Long employeeId){
        employeeService.deleteEmployee(employeeId);
        return ResponseEntity.ok("Employee Delete Successfully!");
    }


}
