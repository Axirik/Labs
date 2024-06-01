package kir.lab.common.util;


import kir.lab.common.entities.Person;

import java.io.Serializable;

public class Request implements Serializable {
    private String message;
    private String id;
    private Person person;

    public Request(String message, String id, Person person) {
        this.message = message;
        this.id = id;
        this.person = person;
    }

    public String getMessage() {
        return message;
    }

    public String getId() {
        return id;
    }

    public Person getPerson() {
        return person;
    }
    public void setMessage(String message) {
        this.message = message;
    }
}

