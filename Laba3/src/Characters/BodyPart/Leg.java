package Characters.BodyPart;

import Characters.BodyParts;

public class Leg extends BodyParts {
    public String name;
    public String site;
    private String condition;


    public Leg(String name, String site) {
        super(name);
        this.name = name;
        this.site = site;
    }

    public void setCondition(String condition) {
        this.condition = condition;
        System.out.println(name + " получает состояние " + condition);
    }
}
