package kir.lab.common.entities;

import java.io.Serializable;

public class Location implements Serializable {
    private long x;
    private Long y; //Поле не может быть null
    private float z;

    public Location(long x, Long y, float z) {
        this.x = x;
        this.y = y;
    }
}
