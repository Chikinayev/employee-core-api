package kzdaracademybackend.controller;

import kzdaracademybackend.model.EmployeeModel;
import kzdaracademybackend.service.deprecated.EmployeeServiceOld;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/deprecated/employee")
public class EmployeeControllerOld {
    @Autowired
    Environment env;
    @Autowired
    private EmployeeServiceOld employeeServiceOld;


    @GetMapping("/check")
    public String check(){
        return "employee-core-api is working at " + env.getProperty("local.server.port");
    }
    @PostMapping
    public ResponseEntity<String> createEmployee(@Valid @RequestBody EmployeeModel employeeModel){
        employeeServiceOld.createEmployee(employeeModel);
        return new ResponseEntity<String>("Successfully created", HttpStatus.OK);
    }

    @GetMapping("/all")
    public List<EmployeeModel> getAllEmployees(){
        return employeeServiceOld.getAllEmployees();
    }

    @GetMapping("/{employeeId}")
    public EmployeeModel getEmployeeById(@PathVariable String employeeId){
        return employeeServiceOld.getEmployeeById(employeeId);
    }
    @PutMapping("/{employeeId}")
    public ResponseEntity<String> updateEmployeeById(@PathVariable String employeeId,
                                                     @Valid @RequestBody EmployeeModel employeeModel ){
        employeeServiceOld.updateEmployeeById(employeeId, employeeModel);
        return new ResponseEntity<>("Successfully updated", HttpStatus.OK);
    }

    @DeleteMapping("/{employeeId}")
    public ResponseEntity<String> deleteEmployeeById(@PathVariable String employeeId){
        employeeServiceOld.deleteEmployeeById(employeeId);
        return new ResponseEntity<>("Successfully deleted",HttpStatus.OK);
    }
}
