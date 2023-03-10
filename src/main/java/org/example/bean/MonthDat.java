package org.example.bean;

import lombok.Getter;
import lombok.Setter;

@Getter@Setter
public class MonthDat {

    private String name;
    private int main;
    private int value = 0;
    
    public MonthDat(String name){
        this.name = name;
    }

    public MonthDat(int main) {
        this.main = main;
    }

    public MonthDat addValue() {
        value++;
        return this;
    }
}
