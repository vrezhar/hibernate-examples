package com.example.inheritance.joined;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "judge")
@PrimaryKeyJoinColumn(name = "official_id")
public class Judge extends GovernmentOfficial {
    private String circuit;
    private int casesJudged;

    public String getCircuit() {
        return circuit;
    }

    public void setCircuit(String circuit) {
        this.circuit = circuit;
    }

    public int getCasesJudged() {
        return casesJudged;
    }

    public void setCasesJudged(int casesJudged) {
        this.casesJudged = casesJudged;
    }
}
