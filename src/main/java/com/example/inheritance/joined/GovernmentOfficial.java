package com.example.inheritance.joined;

import com.example.inheritance.AbstractImmutableEntity;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "government_official")
@Inheritance(strategy = InheritanceType.JOINED)
public class GovernmentOfficial extends AbstractImmutableEntity {
    private String firstName;
    private String lastName;
    private LocalDate swornInOffice;

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

    public LocalDate getSwornInOffice() {
        return swornInOffice;
    }

    public void setSwornInOffice(LocalDate swornInOffice) {
        this.swornInOffice = swornInOffice;
    }
}
