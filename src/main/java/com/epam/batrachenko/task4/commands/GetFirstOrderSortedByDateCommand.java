package com.epam.batrachenko.task4.commands;

import com.epam.batrachenko.task4.repository.ShoppingCartRepository;
import com.epam.batrachenko.task4.services.CartService;
import com.epam.batrachenko.task4.services.StoreService;
import com.epam.batrachenko.task4.util.Constants;
import com.epam.batrachenko.task4.util.DateUtil;

import java.util.Date;
import java.util.Map;
import java.util.Optional;

public class GetFirstOrderSortedByDateCommand extends Command {
    @Override
    public boolean execute(StoreService store, CartService cart) {
        System.out.println(Constants.INPUT_DATE_START);
        Date date;
        try {
            date = DateUtil.inputDate();
        } catch (Exception e) {
            return false;
        }
        Optional<Map.Entry<Date, ShoppingCartRepository>> order = store.getFirstOrderSortedByDate(date);
        order.ifPresent(System.out::println);
        return true;
    }

    @Override
    public String toString() {
        return "Get First Order Sorted By Date";
    }
}
