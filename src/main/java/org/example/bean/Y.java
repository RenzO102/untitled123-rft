package org.example.bean;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Y {
    private int Y;
    private int value = 0;

    public Y( int Y) {
        this.Y = Y;
    }

    public Y addValue2() {
        Y++;
        return this;
    }
}
