package kzdaracademybackend.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@AllArgsConstructor//generates a constructor requiring argument for every field in the annotated class
@Data //It compiles, generates getters/setters for all fields, toString and overrides equals and hashCode incrementally
@NoArgsConstructor//generates a constructor with no parameter
public class EmployeeModel {
    private String employeeId;
    @NotNull(message = "Name can not be empty!")
    private String name;
    @NotNull(message = "Surname can not be empty!")
    @Size(min=2, max=16,message = "Surname must be greater than 2 and less than 16")
    private String surname;
    private String company;
    private String position;
    @Email(message = "incorrect email")
    private String email;
    private double salary;

}
