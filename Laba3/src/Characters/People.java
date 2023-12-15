package Characters;

import Enum.*;
import Interfaces.*;
import Characters.BodyPart.*;

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

    private Locations getLocation() {
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

    public void openDoors() {
        this.moveTo(Locations.WARDROB);
    }

    public void jumpUp(People p) {
        Locations pPlace;
        pPlace = p.getLocation();
        this.moveTo(pPlace);
    }

    public void takeALook(Wardrob wardrob) {
        if (this.getLocation() == Locations.WARDROB) {
            this.setConditional("заглянуть в " + wardrob.name);
            this.setStatus(Feels.CURIOSITY);
            this.detect(wardrob);
        } else {
            this.setConditional(" не может заглянуть " + wardrob.name);
        }
    }

    public void checkWardrob(Wardrob wardrob) {
        int countsomething = 0;
        for (int i = 0; i < wardrob.countShelfs; i++) {
            if (wardrob.shelfs[i] == null || wardrob.shelfs[i] == "Одежда") {
                countsomething++;
                System.out.println(wardrob.shelfs[i]);
            }
        }
        if (countsomething >= 1) {
            System.out.println("В шкафу нет ничего кроме одежды");
        }
    }

    private void detect(Wardrob wardrob) {
        this.checkWardrob(wardrob);
    }

    public void sound(Wardrob wardrob) {
        System.out.println(name + " раздалось с верхней полки " + wardrob.name);
        this.setName("Карлсон");
        wardrob.addInWardrob(physAppearance + " " + name);

    }

    public void lookUp(Wardrob wardrob) {
        String lastShelf = wardrob.shelfs[wardrob.countShelfs - 1];
        if (lastShelf != null) {
            System.out.println(name + " на верхней полке увидел " + lastShelf);
        } else {
            System.out.println(name + " на верхней полке ничего не увидел");
        }
    }

    public void swing(Leg leg) {
        leg.setCondition("качается");
        System.out.println(name + " качает " + leg.site + " " + leg.name);
    }
}
