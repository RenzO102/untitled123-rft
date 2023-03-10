package org.example;

import com.google.common.base.Strings;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.apache.commons.lang3.StringUtils;
import org.example.bean.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.*;

public class Main {

    public static void updateValue(TreeMap<String, Integer> months, String name, Integer main) {
        if (months.containsKey(name)) {
            months.put(name, months.get(name) + main );
        } else {
            months.put(name, main);
        }
    }
    public  void main(String[] args) throws Exception {
        List<Item> items = new Gson().fromJson(
                new String(Files.readAllBytes(Paths.get("test2.json"))),
                new TypeToken<List<Item>>() {
                }.getType());

        TreeMap<String, Integer> months = new TreeMap<>();
        items.stream()
                .forEach(i -> {
                    Month month;
                    MainTest mainTest;

                    try {
                        month = getMoths(i.getName());
                        mainTest = getMain(i.getMain());
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                    if (months.containsKey(month.getName())) {
                        months.get(month.getName()).intValue();
                    } else {
                        month.addValue();
                        months.put(month.getName(), month.getValue());
                    }
                    updateValue(months, month.getName(), mainTest.getMain());

                });
        System.out.println(months.toString());
    }

        public static void updateValueY(TreeMap<String, Integer> monthsY, String name, Integer Y) {
        if (monthsY.containsKey(name)) {
            monthsY.put(name, monthsY.get(name) + Y );
        } else {
            monthsY.put(name, Y);
        }
    }

    private static Month getMoths(String date) throws Exception {
        if (Strings.isNullOrEmpty(date)) {
            System.out.println(" ##### NULL ");
            return new Month("x");
        } else {
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM");
            Date date3 = formatter.parse(StringUtils.substringBefore(date, "T"));
            String formattedDateString = formatter.format(date3);
            return new Month(formattedDateString);
        }
    }

    private static MainTest getMain(int main) throws NullPointerException {
        if (main == 0) {
            System.out.println("null");
        }
        return new MainTest(main);
    }

    private static Y getY(int y) throws NullPointerException {
        if (y == 0) {

            return new Y(y);
        } else {
            return new Y(y);
        }
    }

    private static Z getZ(int z) throws NullPointerException {
        if (z == 0) {
            return new Z(z);
        } else {
            return new Z(z);
        }
    }
}