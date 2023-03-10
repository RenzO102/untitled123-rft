package org.example.bean;

import lombok.Getter;
import lombok.Setter;

@Getter@Setter
public class Weeks {

    private String name;

    private int value = 0;

    public Weeks(String name) {
        this.name = name;
    }


    public Weeks addValue3() {
        value++;
        return this;
    }
}
