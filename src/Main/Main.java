package Main;

import ru.ifmo.se.pokemon.*;
import Pokemon.*;

import java.io.ObjectInputFilter;

public class Main {
    public static void main(String[] args) {
        Battle b = new Battle();
        Xerneas p2 = new Xerneas("Xer",1);
        Lickilicky p1 = new Lickilicky("Licky", 1);
        Lickitung p3 = new Lickitung("Likit", 1);

        Seedot p4 = new Seedot("See",1);
        Nuzleaf p5 =new Nuzleaf("Nuz",1);
        Shiftry p6 = new Shiftry("Shi",1);


        b.addAlly(p1);
        b.addAlly(p2);
        b.addAlly(p3);

        b.addFoe(p4);
        b.addFoe(p5);
        b.addFoe(p6);
        b.go();

    }

    public static boolean chance(double d) {
        return d>Math.random();
    }
}
