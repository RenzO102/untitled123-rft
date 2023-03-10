package org.example.Week;

import com.google.common.base.Strings;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.example.bean.Item;
import org.example.bean.Weeks;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.temporal.IsoFields;
import java.util.List;

public class Week {
    public static void week(String[] args) throws Exception{
        List<Item> items = new Gson().fromJson(
                new String(Files.readAllBytes(Paths.get("test2.json"))),
                new TypeToken<List<Item>>() {
                }.getType());
        System.out.println(items);
    }


//    private static Weeks getWeek(String date) throws Exception {
//        if (Strings.isNullOrEmpty(date)) {
//            System.out.println("null");
//            return new Week(date);
//        } else {
//            LocalDate ld = LocalDate.parse(date);
//            int week = ld.get(IsoFields.WEEK_OF_WEEK_BASED_YEAR);
//            System.out.println(week);
//            return new Week(date);
//        }

    }