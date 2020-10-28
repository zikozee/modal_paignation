package com.zikozee.modal_paignation.service;

import com.zikozee.modal_paignation.model.SomeDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EmployeeDeleteServiceImpl implements EmployeeDeleteService{

    @Autowired
    private JdbcTemplate template;


    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public SomeDTO deleteByTemplate(String firstName, String lastName) {
        template.update("DELETE from employee where first_name = ? and last_name like ?",(statement) -> {
            statement.setString(1, firstName);
            statement.setString(2, "%" + lastName + "%");
        });

        return SomeDTO.builder().firstName(firstName).lastName(lastName).build();
    }


}
