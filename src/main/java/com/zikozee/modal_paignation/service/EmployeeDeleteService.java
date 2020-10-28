package com.zikozee.modal_paignation.service;

import com.zikozee.modal_paignation.model.SomeDTO;

public interface EmployeeDeleteService {

    SomeDTO deleteByTemplate(String firstName, String LastName);

}
