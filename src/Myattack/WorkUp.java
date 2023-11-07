package Myattack;

import Main.Main;
import ru.ifmo.se.pokemon.*;

public class WorkUp extends StatusMove {
    public WorkUp(double pow, double acc){
        super(Type.NORMAL,pow,acc);
    }
    @Override
    protected void applyOppEffects(Pokemon p){
        p.setMod(Stat.ATTACK,+1);
        p.setMod(Stat.SPECIAL_ATTACK,+1);
    }

    @Override
    protected String describe(){
        return "использует WorkUp";
    }
}
