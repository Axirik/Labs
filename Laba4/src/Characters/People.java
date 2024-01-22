package Characters;

import Enum.*;
import Exceptions.DoorsOpenedException;
import Exceptions.LocationException;
import Interfaces.*;

public class People implements Movable, Looking{

    private String name;
    private int age;
    private String physAppearance;
    private Locations location;
    private Feels status;
    private String conditional;


    public People(String name, int age, String physAppearance, Locations location, Feels status) {
        this.name = name;
        this.location = location;
        this.age = age;
        this.physAppearance = physAppearance;
        this.status = status;
    }

    @Override
    public String toString() {
        return name;
    }

    public void moveTo(Locations location) {
        this.setLocation(location);
    }

    public void lay(LastShelf shelf) {
        shelf.addShelf(name);
        System.out.println(name + " лежит на " + shelf.name);
    }

    private void setName(String name) {
        this.name = name;
    }
    public String getName(){
        return this.name;
    }

    private void setStatus(Feels status) {
        this.status = status;
        System.out.println(name + " получает статус " + status);
    }

    private Feels getStatus() {
        return status;
    }

    private void setConditional(String conditional) {
        this.conditional = conditional;
        System.out.println(name + " получает состояние " + conditional);
    }


    private void setLocation(Locations location) {
        this.location = location;
        System.out.println(name + " перемещается в " + location);
    }

    public Locations getLocation() {
        return location;
    }

    public void grumble() {
        setStatus(Feels.GRUMPINESS);
        System.out.println(name + " заворчал");
    }

    public void squint(Things thing) {
        if (this.getStatus() == Feels.GRUMPINESS) {
            this.setConditional("смотрит на " + thing.name);
        } else {
            this.setConditional("не ворчит");
        }
    }

    public void burstOutLauthing() {
        this.setStatus(Feels.LAUGH);
        System.out.println(name + " расмеялся");
    }

    public void talk() {
        if (this.status == Feels.LAUGH) {
            this.setConditional("не может говорить");
        } else {
            this.setConditional("может говорить");
        }
    }

    public void openDoors(Wardrob wardrob) throws DoorsOpenedException {
        this.moveTo(Locations.WARDROB);
        wardrob.door.setConditional("открыта");
        if (wardrob.door.getConditional() == "открыта"){
            throw new DoorsOpenedException();
        }
        else{
            wardrob.door.setConditional("открыта");
            System.out.println(this.name + " открывает дверь" );
        }
    }

    public void jumpUp(People p) throws LocationException {
        Locations pPlace;
        pPlace = p.getLocation();
        this.setLocation(pPlace);
        if (this.location == pPlace){
            throw new LocationException();
        }
        else{
            this.moveTo(pPlace);
        }
    }

    public void takeALook(Wardrob wardrob) {
        if (this.getLocation() == Locations.WARDROB) {
            this.setConditional("заглянуть в " + wardrob.name);
            this.setStatus(Feels.CURIOSITY);
            this.checkWardrob(wardrob);
        } else {
            this.setConditional(" не может заглянуть " + wardrob.name);
        }
    }

    public void checkWardrob(Wardrob wardrob) {
        int countsomething = 0;
        for (int i = 0; i < wardrob.getCountShelfs(); i++) {
            String[] shelfs = wardrob.getShelfs();
            if (shelfs[i] == null || shelfs[i] == "Одежда") {
                countsomething++;
                System.out.println(shelfs[i]);
            }
        }
        if (countsomething >= 1) {
            System.out.println("В шкафу нет ничего кроме одежды");
        }
    }


    public void sound(Wardrob wardrob) {
        System.out.println(name + " раздалось с верхней полки " + wardrob.name);
        this.setName("Карлсон");
        wardrob.addInWardrob(physAppearance + " " + name);

    }

    public void lookUp(Wardrob wardrob) {
        String lastShelf = wardrob.getShelfs()[wardrob.getCountShelfs() - 1];
        if (lastShelf != null) {
            System.out.println(name + " на верхней полке увидел " + lastShelf);
        } else {
            System.out.println(name + " на верхней полке ничего не увидел");
        }
    }

    public void swing(BodyParts.Leg leg) {
        leg.setCondition("качается");
        System.out.println(name + " качает " + leg.site + " " + leg.name);
    }
    public void laugh(){
        this.setStatus(Feels.LAUGH);
        class Dimples{
            private boolean havedimples;

            public void setDimples(boolean now){
                this.havedimples = now;
                System.out.println("Ямочки появились на щечках");
            }
        }
        Dimples dimples = new Dimples();
        dimples.setDimples(true);
    }
}
