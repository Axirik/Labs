package Exceptions;

public class LocationException extends Exception{
    public LocationException(){
        super("Уже находиться в ");
    }
}
