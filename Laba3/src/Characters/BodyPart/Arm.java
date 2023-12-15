package Characters.BodyPart;

import Characters.BodyParts;

public class Arm extends BodyParts {
    String name;
    private String site;
    private String condition;

    public Arm(String name, String site) {
        super(name);
        this.name = name;
        this.site = site;
    }

    public void setCondition(String condition) {
        this.condition = condition;
        System.out.println(name + " получает состояние " + condition);
    }

    public void keep(Head head) {
        head.keeping();
        this.setCondition("держит " + head.name);
        System.out.println(site + " " + name + " держит " + head.name);
    }
}
