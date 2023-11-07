package Myattack;

import Main.Main;
import ru.ifmo.se.pokemon.*;

public class RockSlide extends PhysicalMove {
    public RockSlide(double pow, double acc){
        super(Type.ROCK,pow,acc);
    }
    @Override
    protected void applyOppEffects(Pokemon p){
        super.applyOppEffects(p);
        if (Main.chance(0.3)){
            Effect.flinch(p);
        }
    }

    @Override
    protected String describe(){
        return "использует RockSlide";
    }
}
