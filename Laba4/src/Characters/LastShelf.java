package Characters;

import Enum.Locations;

public class LastShelf extends Things {
    String name;
    Locations location;
    String material;
    String shelf;

    public LastShelf(String name, Locations location, String material) {
        super(name, location, material);
        this.name = name;
        this.location = location;
        this.material = material;
    }

    public void addShelf(String name) {
        this.shelf = name;
    }

}
