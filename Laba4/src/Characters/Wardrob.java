package Characters;

import Enum.Locations;

public class Wardrob extends Things {
    private int countShelfs;
    private String[] shelfs;
    Door door = new Door();


    public Wardrob(String name, int countShelfs, Locations location, String material) {
        super(name, location, material);
        this.name = name;
        this.location = location;
        this.material = material;
        this.countShelfs = countShelfs;
        this.shelfs = new String[countShelfs];
    }
    public String[] getShelfs(){
        return this.shelfs;
    }
    public int getCountShelfs(){
        return this.countShelfs;
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
    class Door{
        private  String site;
        private  String conditional;


        public void setConditional(String conditional){
            this.conditional = conditional;
        }
        public String getConditional(){
            return conditional;
        }
    }


}
