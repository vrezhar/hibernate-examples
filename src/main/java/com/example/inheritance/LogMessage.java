package com.example.inheritance;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "log_message")
public class LogMessage extends AbstractImmutableEntity {
    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
