package Characters;

import Enum.Locations;

public class Things {

    protected String name;
    protected Locations location;
    protected String material;

    public Things(String name, Locations location, String material) {
        this.name = name;
        this.location = location;
        this.material = material;
    }

    public void setLocation(Locations location) {
        this.location = location;
    }

    public void setMaterial(String material) {
        this.material = material;
    }
}
