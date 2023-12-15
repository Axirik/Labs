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
}
