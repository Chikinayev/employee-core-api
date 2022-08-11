package kzdaracademybackend.service.employee;

import kzdaracademybackend.model.EmployeeRequest;
import kzdaracademybackend.model.EmployeeResponse;

import java.util.List;

public interface EmployeeService {
    EmployeeResponse createEmployee(EmployeeRequest employeeRequest);

    EmployeeResponse updateEmployee(EmployeeRequest employeeRequest);

    EmployeeResponse getEmployeeById(String employeeId);

    List<EmployeeResponse> getAllEmployees();

    void deleteEmployeeById(String employeeId);

    List<EmployeeResponse> getEmployeesBySurname(String surname);

    EmployeeResponse getEmployeeByName(String name);
}
