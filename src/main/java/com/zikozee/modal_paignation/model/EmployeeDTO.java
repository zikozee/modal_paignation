package com.zikozee.modal_paignation.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EmployeeDTO {

    private Long id;

    @NotNull
    @Size(min = 1, max = 20, message = "must be between 1 to 20")
    private String firstName;

    @Size(min = 1, max = 20, message = "must be between 1 to 20")
    private String lastName;

    @Email(regexp = "^[_A-Za-z0-9-+]+(.[_A-Za-z0-9-]+)*@\" + \"[A-Za-z0-9-]+(.[A-Za-z0-9]+)*(.[A-Za-z]{2,})$", message="Invalid email!")
    @NotBlank(message = "cannot be empty")
    private String email;
    
}
