package com.zikozee.modal_paignation.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class SomeDTO {
    private String firstName;
    private String lastName;
}
