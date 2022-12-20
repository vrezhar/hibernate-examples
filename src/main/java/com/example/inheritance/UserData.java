package com.example.inheritance;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "user_data")
public class UserData extends AbstractMutableEntity {
    private String firstName;
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
