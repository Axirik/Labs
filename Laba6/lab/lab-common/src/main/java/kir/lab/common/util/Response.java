package kir.lab.common.util;

import kir.lab.common.entities.Person;

import java.io.Serializable;

public class Response  implements Serializable {
    String message;
    public Response(String message){
        this.message = message;
    }
    public String getMessage(){
        return message;
    }
}
