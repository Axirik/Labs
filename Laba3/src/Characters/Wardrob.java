package Characters;

import Enum.Locations;

public class Wardrob extends Things {
    String name;
    Locations location;
    String material;
    public int countShelfs;
    public String[] shelfs;


    public Wardrob(String name, int countShelfs, Locations location, String material) {
        super(name, location, material);
        this.name = name;
        this.location = location;
        this.material = material;
        this.countShelfs = countShelfs;
        shelfs = new String[countShelfs];
    }

    public void fullWardrob(String name) {
        for (int i = 0; i < chance(); i++) {
            this.shelfs[i] = name;
        }
    }

    public void addInWardrob(String name) {
        this.shelfs[this.countShelfs - 1] = name;
    }

    private int chance() {
        return (int) (Math.random() * 2 + 1);

    }


}
