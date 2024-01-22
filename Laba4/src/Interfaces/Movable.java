package Interfaces;
import Characters.LastShelf;
import Enum.*;
public interface Movable {
    public void moveTo(Locations locations);

    public void lay(LastShelf shelf);
}
