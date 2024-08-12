package com.capstone.tealeaf.form;

import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.Length;

@Getter
@Setter
@ToString
public class CreateAccountFormBean {
//    @NotEmpty
//    private String email;
//
//    @NotEmpty
////    @Length(min= 4, message="password must have at least four characters")
//    private String password;

    private Integer id;

    @Length(max = 50, message = "Email must be less than 50 characters")
//    Requirement: Form bean with 2 different validation annotations
    @NotEmpty(message = "Email is required.") // Requirement: Form bean with 2 different validation annotations
    private String email;

    @Length(max = 100, message = "Password must be less than 100 characters")
//    // Requirement: Form bean with 2 different validation annotations
    @NotEmpty(message = "Password is required.") // Requirement: Form bean with 2 different validation annotations
    private String password;

}
