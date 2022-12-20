package com.example.inheritance.joined;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "minister")
@PrimaryKeyJoinColumn(name = "official_id")
public class Minister extends GovernmentOfficial {
    private String ministry;

    public String getMinistry() {
        return ministry;
    }

    public void setMinistry(String ministry) {
        this.ministry = ministry;
    }
}
