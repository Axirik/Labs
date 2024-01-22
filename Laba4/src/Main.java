import Characters.*;
import Enum.*;
import Exceptions.DoorsOpenedException;
import Exceptions.LocationException;

public class Main {

    public static void main(String[] args) {

        People Effa = new People("Эффа", 6, "худой", Locations.ROOM, Feels.NORMAL);
        People Baby = new People("Малыш", 12, "худой", Locations.ROOM, Feels.NORMAL);
        People Gunnila = new People("Гуннила", 12, "худой", Locations.ROOM, Feels.NORMAL);
        People Krister = new People("Кристер", 12, "худой", Locations.ROOM, Feels.NORMAL);
        Wardrob wardrob = new Wardrob("Шкаф", 3, Locations.ROOM, "Дерево");
        Clothes clothes = new Clothes("Одежда", Locations.SHELF, "Ткань");
        People Karlson = new People("Хихиканье", 23, "маленький толстый", Locations.SHELF, Feels.NORMAL);
        LastShelf shelf = new LastShelf("Последняя полка", Locations.WARDROB, "Дерево");
        BodyParts.Arm arm = new BodyParts.Arm("Рука", "левая");
        BodyParts.Leg leg = new BodyParts.Leg("Нога", "правая");
        BodyParts.Leg leg1 = new BodyParts.Leg("Нога", "правая");
        BodyParts.Head head = new BodyParts.Head("Голова", "Рыжие", "Короткие");
        BodyParts.Eyes eyes = new BodyParts.Eyes("Глаза", "Голубые", true);
        //anonim class
        People Mum = new People("Мама", 34,"худой",Locations.ROOM,Feels.NORMAL){
            @Override
            public void talk(){
                System.out.println(this.getName() + " спросила Малыша");
            }
        };
        Mum.talk();



        Gunnila.laugh();
        Effa.grumble();
        Effa.squint(wardrob);
        Baby.burstOutLauthing();
        Baby.talk();
        //exception
        try{
            Gunnila.openDoors(wardrob);
        }catch (DoorsOpenedException e){
            System.out.println(e.getMessage());
        }

        clothes.hanging(wardrob);
        Gunnila.takeALook(wardrob);
        try{
            Krister.jumpUp(Gunnila);
        }catch (LocationException e){
            System.out.println("" + e + Gunnila.getLocation());
        }

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