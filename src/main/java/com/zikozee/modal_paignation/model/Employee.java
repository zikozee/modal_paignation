package com.zikozee.modal_paignation.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity(name = "employee")
@Table(name =  "employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    private String email;

    public Employee(String firstName, String lastName, String email){
        this.firstName  = firstName;
        this.lastName  = lastName;
        this.email  = email;
    }
}
