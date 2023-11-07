package Myattack;

import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.SpecialMove;
import ru.ifmo.se.pokemon.Stat;
import ru.ifmo.se.pokemon.Type;
import Main.*;
public class FocusBlast extends SpecialMove {
    public FocusBlast(double pow, double acc){
        super(Type.FIGHTING,pow,acc);
    }
    @Override
    protected void applyOppEffects(Pokemon p){
        super.applyOppEffects(p);
        if (Main.chance(0.1)){
            p.setMod(Stat.SPECIAL_DEFENSE,-1);
        }

    }

    @Override
    protected String describe(){
        return "использует FocusBlast";
    }
}
