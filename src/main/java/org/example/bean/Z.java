package org.example.bean;

import lombok.Getter;
import lombok.Setter;

@Getter@Setter
public class Z {
    private int Z;
    private int value = 0;

    public Z( int Y) {
        this.Z = Z;
    }

    public Z addValue3() {
        Z++;
        return this;
    }
}
