package Pokemon;

import Myattack.*;
import ru.ifmo.se.pokemon.Type;

public class Nuzleaf extends Seedot{
    public Nuzleaf(String name, int level) {
        super(name, level);
        super.setType(Type.GRASS,Type.DARK);
        super.setStats(70, 70, 40, 60, 40, 60);


        Swagger swagger = new Swagger(0,85);
        Facade facade = new Facade(70,100);
        Pound pound = new Pound(40,100);

        super.setMove(swagger,facade,pound);

    }
}
