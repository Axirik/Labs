package Pokemon;


import Myattack.*;
import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.Type;

public class Lickitung extends Pokemon {
    public Lickitung(String name, int level) {
        super(name, level);
        super.setType(Type.NORMAL);
        super.setStats(90, 55, 75, 60, 75, 30);

        RockTomb rockTomb = new RockTomb(60, 95);
        RockSlide rockSlide = new RockSlide(75,90);
        WorkUp workUp = new WorkUp(0,0);

        super.setMove(rockTomb,rockSlide,workUp);

    }
}
