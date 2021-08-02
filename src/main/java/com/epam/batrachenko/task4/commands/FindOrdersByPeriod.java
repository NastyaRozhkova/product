package com.epam.batrachenko.task4.commands;

import com.epam.batrachenko.task4.services.CartService;
import com.epam.batrachenko.task4.services.StoreService;
import com.epam.batrachenko.task4.util.Constants;
import com.epam.batrachenko.task4.util.DateUtil;

import java.util.Date;

public class FindOrdersByPeriod extends Command {
    @Override
    public boolean execute(StoreService store, CartService cart) {
        System.out.println(Constants.INPUT_DATE_START);
        Date start;
        try {
            start = DateUtil.inputDate();
        } catch (Exception e) {
            return false;
        }
        System.out.println(Constants.INPUT_DATE_END);
        Date end;
        try {
            end = DateUtil.inputDate();
        } catch (Exception e) {
            return false;
        }
        store.getOrdersByPeriod(start, end).forEach(System.out::println);
        return true;
    }

    @Override
    public String toString() {
        return "Find Orders By Period";
    }
}
