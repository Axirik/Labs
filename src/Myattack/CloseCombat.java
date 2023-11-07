package Myattack;

import ru.ifmo.se.pokemon.*;

public class CloseCombat extends PhysicalMove {
    public CloseCombat(double pow, double acc){
        super(Type.FIGHTING,pow,acc);
    }
    @Override
    protected void applySelfEffects(Pokemon p){
        p.setMod(Stat.DEFENSE,-1);
        p.setMod(Stat.SPECIAL_DEFENSE,-1);
    }

    @Override
    protected String describe(){
        return "использует CloseCombat";
    }
}
