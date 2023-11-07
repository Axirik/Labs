package Pokemon;

import Myattack.*;
import ru.ifmo.se.pokemon.Type;

public class Lickilicky extends Lickitung{
    public Lickilicky(String name, int level) {
        super(name, level);
        super.setType(Type.NORMAL);
        super.setStats(110, 85, 95, 80, 95, 50);

        RockTomb rockTomb = new RockTomb(60, 95);
        RockSlide rockSlide = new RockSlide(75,90);
        WorkUp workUp = new WorkUp(0,0);
        FocusBlast focusBlast = new FocusBlast(120,70);
        super.setMove(rockTomb,rockSlide,workUp,focusBlast);

    }
}
