package Pokemon;

import Myattack.*;
import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.Type;

public class Xerneas extends Pokemon {
    public Xerneas(String name, int level) {
        super(name, level);
        super.setType(Type.FAIRY);
        super.setStats(126, 131, 95, 131, 98, 99);


        CloseCombat closeCombat = new CloseCombat(120, 100);
        DazzlingGleam dazzlingGleam = new DazzlingGleam(80,100);
        DoubleTeam doubleTeam = new DoubleTeam(0,0);
        FocusBlast focusBlast = new FocusBlast(120,70);

        super.setMove(closeCombat,dazzlingGleam,doubleTeam,focusBlast);

    }
}
