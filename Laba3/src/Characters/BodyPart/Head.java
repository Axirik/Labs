package Characters.BodyPart;

import Characters.BodyParts;

public class Head extends BodyParts {
    String name;
    private String hairColor;
    private String hairLenght;
    private String condition;

    public Head(String name, String hairColor, String hairLenght) {
        super(name);
        this.name = name;
        this.hairColor = hairColor;
        this.hairLenght = hairLenght;
    }

    public void setCondition(String condition) {
        this.condition = condition;
        System.out.println(name + " получает состояние " + condition);
    }

    public void keeping() {
        this.setCondition("держиться на руке");
    }
}
