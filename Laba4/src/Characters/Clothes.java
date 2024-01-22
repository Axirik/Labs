package Characters;

import Enum.Locations;

public class Clothes extends Things {

    public Clothes(String name, Locations location, String material) {
        super(name, location, material);
        this.name = name;
        this.location = location;
        this.material = material;
    }

    public void hanging(Wardrob wardrob) {
        wardrob.fullWardrob(this.name);

    }
}
