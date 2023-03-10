package org.example.bean;

import lombok.Getter;
import lombok.Setter;

@Getter@Setter
public class MainTest {

    private int main;
    private int value = 0;

    public MainTest( int main) {
        this.main = main;
    }

    public MainTest addValue1() {
        main++;
        return this;
    }
}
