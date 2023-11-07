package Myattack;

import ru.ifmo.se.pokemon.*;

public class Facade extends PhysicalMove {
    public Facade(double pow, double acc){
        super(Type.ROCK,pow,acc);
    }

    @Override
    protected void applyOppDamage(Pokemon p, double damage){

        Effect.burn(p);
        Status statu = p.getCondition();
        if ((statu == Status.BURN) || (statu == Status.POISON) || (statu == Status.PARALYZE))
            super.applyOppDamage(p,damage*2);
        else
            super.applyOppDamage(p,damage);
    }

    @Override
    protected String describe(){
        return "использует Facade";
    }
}
