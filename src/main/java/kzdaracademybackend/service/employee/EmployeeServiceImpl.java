package kzdaracademybackend.service.employee;

import kzdaracademybackend.model.EmployeeRequest;
import kzdaracademybackend.model.EmployeeResponse;
import kzdaracademybackend.repository.EmployeeEntity;
import kzdaracademybackend.repository.EmployeeRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.modelmapper.spi.MatchingStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;


@Service
public class EmployeeServiceImpl implements EmployeeService{

    @Autowired
    EmployeeRepository employeeRepository;

    static ModelMapper modelMapper = new ModelMapper();

    static {
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
    }

    @Override
    public EmployeeResponse createEmployee(EmployeeRequest employeeRequest) {
        employeeRequest.setEmployeeId(UUID.randomUUID().toString());

        EmployeeEntity employeeEntity = modelMapper.map(employeeRequest, EmployeeEntity.class);
        employeeRepository.save(employeeEntity);

        return modelMapper.map(employeeEntity, EmployeeResponse.class);
    }

    @Override
    public EmployeeResponse updateEmployee(EmployeeRequest employeeRequest) {
        EmployeeEntity employeeEntity = modelMapper.map(employeeRequest, EmployeeEntity.class);

        EmployeeEntity dbEntity = employeeRepository.getEmployeeEntityByEmployeeId(employeeRequest.getEmployeeId());

        employeeEntity.setId(dbEntity.getId());
        employeeRepository.save(employeeEntity);

        return modelMapper.map(employeeEntity, EmployeeResponse.class);
    }

    @Override
    public EmployeeResponse getEmployeeById(String employeeId) {
        EmployeeEntity employeeEntity = employeeRepository.getEmployeeEntityByEmployeeId(employeeId);

        return modelMapper.map(employeeEntity, EmployeeResponse.class);
    }

    @Override
    public List<EmployeeResponse> getAllEmployees() {
        return employeeRepository.getEmployeeEntitiesBy().stream()
                .map(employee -> modelMapper.map(employee, EmployeeResponse.class))
                .collect(Collectors.toList());
    }

    @Override
    public void deleteEmployeeById(String employeeId) {
        employeeRepository.deleteEmployeeEntityByEmployeeId(employeeId);

    }

    @Override
    public List<EmployeeResponse> getEmployeesBySurname(String surname) {
        return employeeRepository.getEmployeeEntitiesBySurname(surname).stream()
                .map(employee->modelMapper.map(employee,EmployeeResponse.class))
                .collect(Collectors.toList());
    }

    @Override
    public EmployeeResponse getEmployeeByName(String name) {
        EmployeeEntity employeeEntity = employeeRepository.getEmployeeEntityByName(name);
        return modelMapper.map(employeeEntity, EmployeeResponse.class);
    }
}
