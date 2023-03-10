package org.example.Week;

import com.google.common.base.Strings;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.apache.commons.lang3.StringUtils;
import org.example.bean.Item;
import org.example.bean.Week;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.WeekFields;
import java.util.*;

public class WeekMain {
    public static void main(String[] args) throws Exception{
        List<Item> items = new Gson().fromJson(
                new String(Files.readAllBytes(Paths.get("test2.json"))),
                new TypeToken<List<Item>>() {
                }.getType());

        TreeMap<String, Integer> weeks = new TreeMap<>();
        items.stream()
                .forEach(i -> {
                    Week week;
                    try {
                        week = getWeek(i.getName());
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                    if (weeks.containsKey(week.getName())) {
                        weeks.get(week.getName()).intValue();
                    } else {
                        week.addValue3();
                        weeks.put(week.getName(), week.getValue());
                    }


                });
      System.out.println(weeks.toString());
    }

    private static Week getWeek(String date)  {
        if (Strings.isNullOrEmpty(date)) {
            System.out.println(" ##### NULL ");
            return new Week("x");
        } else {
            LocalDate date2 = LocalDate.parse(date);
            int weekOfYear = date2.get(WeekFields.of(Locale.GERMAN).weekOfYear());
//            System.out.println(weekOfYear);
            return new Week(String.valueOf(weekOfYear));

        }
    }

    }