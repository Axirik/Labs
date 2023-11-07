package Myattack;

import ru.ifmo.se.pokemon.PhysicalMove;
import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.Stat;
import ru.ifmo.se.pokemon.Type;

public class LowSweep extends PhysicalMove {
    public LowSweep(double pow, double acc){
        super(Type.FIGHTING,pow,acc);
    }
    @Override
    protected void applyOppEffects(Pokemon p){
        p.setMod(Stat.SPEED,-1);
    }

    @Override
    protected String describe(){
        return "использует LowSweep";
    }
}

