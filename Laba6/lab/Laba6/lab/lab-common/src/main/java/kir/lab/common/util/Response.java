package kir.lab.common.util;

import java.io.Serializable;

public class Response implements Serializable {
    private String message;
    private int flag;

    public Response(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
    public void  setMessage(String string){
        this.message = string;
    }
    public void setFlag(int flag){
        this.flag = flag;
    }
    public int getFlag(){
        return flag;
    }
}
