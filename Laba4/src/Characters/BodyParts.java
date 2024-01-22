package Characters;

import java.util.Objects;

public abstract class BodyParts {
    protected String name;

    public BodyParts(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BodyParts bodyParts = (BodyParts) o;
        return Objects.equals(name.toLowerCase(), bodyParts.name.toLowerCase());
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }


    public static class Leg extends BodyParts {
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
    public static class Head extends BodyParts {
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

    public static class Arm extends BodyParts {
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

        public void keep(BodyParts.Head head) {
            head.keeping();
            this.setCondition("держит " + head.name);
            System.out.println(site + " " + name + " держит " + head.name);
        }
    }
    public static class Eyes extends BodyParts {
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
        public static void run(){

        }

    }











}
