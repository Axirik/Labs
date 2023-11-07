package Myattack;

import ru.ifmo.se.pokemon.*;

public class Swagger extends StatusMove {
    public Swagger(double pow, double acc){
        super(Type.ROCK,pow,acc);
    }
    @Override
    protected void applyOppEffects(Pokemon p){
        Effect.confuse(p);
        p.setMod(Stat.ATTACK,+2);
    }

    @Override
    protected String describe(){
        return "использует Swagger и сбивает опонента с толку";
    }
}
