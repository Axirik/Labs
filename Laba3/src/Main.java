import Characters.*;
import Characters.BodyPart.*;
import Enum.*;

public class Main {

    public static void main(String[] args) {

        People Effa = new People("Эффа", 20, "худой", Locations.ROOM, Feels.NORMAL);
        People Baby = new People("Малыш", 12, "худой", Locations.ROOM, Feels.NORMAL);
        People Gunnila = new People("Гуннила", 32, "худой", Locations.ROOM, Feels.NORMAL);
        People Krister = new People("Кристер", 28, "худой", Locations.ROOM, Feels.NORMAL);
        Wardrob wardrob = new Wardrob("Шкаф", 3, Locations.ROOM, "Дерево");
        Clothes clothes = new Clothes("Одежда", Locations.SHELF, "Ткань");
        People Karlson = new People("Хихиканье", 23, "маленький толстый", Locations.SHELF, Feels.NORMAL);
        LastShelf shelf = new LastShelf("Последняя полка", Locations.WARDROB, "Дерево");
        Arm arm = new Arm("Рука", "левая");
        Leg leg = new Leg("Нога", "правая");
        Leg leg1 = new Leg("Нога", "правая");
        Head head = new Head("Голова", "Рыжие", "Короткие");
        Eyes eyes = new Eyes("Глаза", "Голубые", true);

        Effa.grumble();
        Effa.squint(wardrob);
        Baby.burstOutLauthing();
        Baby.talk();
        Gunnila.openDoors();
        clothes.hanging(wardrob);
        Gunnila.takeALook(wardrob);
        Krister.jumpUp(Gunnila);
        Krister.takeALook(wardrob);
        Karlson.sound(wardrob);
        Krister.lookUp(wardrob);
        Gunnila.lookUp(wardrob);
        Karlson.lay(shelf);
        arm.keep(head);
        Karlson.swing(leg);
        eyes.light();

        System.out.println();
        System.out.println(leg.equals(leg1));


        //wardrob.getShelfs();


//        String[] array = new String[3];
//        for (int i =0;i<=2;i++){
//            System.out.println(array[i]);
//        }
    }


}