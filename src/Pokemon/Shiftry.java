package Pokemon;

import Myattack.*;
import ru.ifmo.se.pokemon.Type;

public class Shiftry extends Nuzleaf{
    public Shiftry(String name, int level) {
        super(name, level);
        super.setType(Type.GRASS,Type.DARK);
        super.setStats(90, 100, 60, 90, 60, 80);


        Swagger swagger = new Swagger(0,85);
        Facade facade = new Facade(70,100);
        Pound pound = new Pound(40,100);
        LowSweep lowSweep = new LowSweep(65,100);

        super.setMove(swagger,facade,pound,lowSweep);

    }
}
