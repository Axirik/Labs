package Exceptions;

public class DoorsOpenedException extends RuntimeException{
    public DoorsOpenedException(){
        super("Дверь уже открыта");
    }
}
