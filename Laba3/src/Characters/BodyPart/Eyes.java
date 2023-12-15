package Characters.BodyPart;

import Characters.BodyParts;

import java.sql.SQLOutput;

public class Eyes extends BodyParts {
    String name;
    private String color;
    private boolean highvision;


    public Eyes(String name, String color, Boolean highvision) {
        super(name);
        this.name = name;
        this.color = color;
        this.highvision = highvision;
    }

    public void light() {
        System.out.println(this.color + " " + name + " светятся");
    }

}
