package kzdaracademybackend.controller;

import kzdaracademybackend.model.EmployeeRequest;
import kzdaracademybackend.model.EmployeeResponse;
import kzdaracademybackend.service.employee.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {


    @Autowired
    EmployeeService employeeService;


    @PostMapping
    public EmployeeResponse createEmployee(@RequestBody EmployeeRequest employeeRequest){
        return employeeService.createEmployee(employeeRequest);
    }
    @PutMapping
    public EmployeeResponse updateEmployee(@RequestParam String employeeId, @RequestBody EmployeeRequest employeeRequest){
        employeeRequest.setEmployeeId(employeeId);
        return employeeService.updateEmployee(employeeRequest);
    }

    @GetMapping
    public EmployeeResponse getEmployeeById(@RequestParam String employeeId){
        return employeeService.getEmployeeById(employeeId);
    }

    @GetMapping("/all")
    public List<EmployeeResponse> getAllEmployees(){
        return employeeService.getAllEmployees();
    }

    @DeleteMapping
    public void deleteEmployeeById(@RequestParam String employeeId){
        employeeService.deleteEmployeeById(employeeId);
    }

    @GetMapping("/surname")
    public List<EmployeeResponse> getEmployeesBySurname(@RequestParam String surname){
        return employeeService.getEmployeesBySurname(surname);
    }
    @GetMapping("/name")
    public EmployeeResponse getEmployeeByName(@RequestParam String name){
        return employeeService.getEmployeeByName(name);
    }
}
