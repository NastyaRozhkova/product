package com.epam.batrachenko.task4.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 * Contain static method for getting Date in format "dd-MM-yyyy" from console.
 *
 * @author Vladyslav Batrachenko
 * @see SimpleDateFormat,Date
 */
public class DateUtil {
    public static Date inputDate() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        Date date = null;
        try {
            date = dateFormat.parse(inputDateInString());
        } catch (ParseException e) {
            System.out.println("Incorrect data value! Input again in format dd-MM-yyyy");
        }
        return date;
    }

    public static String inputDateInString() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        boolean flag = true;
        Date date = null;
        String dateLine = null;
        Scanner scanner = new Scanner(System.in);
        while (flag) {
            try {
                dateLine = scanner.nextLine();
                date = dateFormat.parse(dateLine);
                flag = false;
            } catch (ParseException e) {
                System.out.println("Incorrect data value! Input again in format dd-MM-yyyy");
            }
        }
        return dateLine;
    }

    public static int compareTwoDateByThird(Date d1, Date d2, Date d3) {
        return (int) (Math.abs(d1.getTime() - d3.getTime()) - Math.abs(d2.getTime() - d3.getTime()));
    }
}
