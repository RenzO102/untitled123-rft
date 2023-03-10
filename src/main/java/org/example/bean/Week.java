package org.example.bean;

import lombok.Getter;
import lombok.Setter;

@Getter@Setter
public class Week {

    private String name;

    private int value = 0;

    public Week(String name) {
        this.name = name;
    }


    public Week addValue3() {
        value++;
        return this;
    }
}
