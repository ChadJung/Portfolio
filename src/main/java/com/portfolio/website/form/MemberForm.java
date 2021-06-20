package com.portfolio.website.form;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@Getter @Setter
public class MemberForm {

    @NotEmpty(message = "Member name cannot be left empty.")
    private String name;

    private String city;
    private String street;
    private String zipcode;
}
