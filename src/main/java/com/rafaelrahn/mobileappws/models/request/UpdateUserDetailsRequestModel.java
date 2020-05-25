package com.rafaelrahn.mobileappws.models.request;

import javax.validation.constraints.NotNull;

public class UpdateUserDetailsRequestModel {
    @NotNull
    private String firstName;
    @NotNull
    private String lastName;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
