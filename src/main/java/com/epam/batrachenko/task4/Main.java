package com.epam.batrachenko.task4;

import com.epam.batrachenko.task1.Entity.Product;
import com.epam.batrachenko.task4.Store.ConsoleStore;
import com.epam.batrachenko.task4.Store.ShoppingCart;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Main {
    private final static String menu = "Input code of operation\n" +
            "0 - Exit\n1 - Show list of products\n2 - Add product to shopping cart\n" +
            "3 - Show shopping cart\n4 - Create order\n5 - Show last 5 products in shopping cart\n" +
            "6 - Show orders for a period of time\n" +
            "7 - Show order for a data";
    private final static Scanner scanner = new Scanner(System.in);
    private final static ConsoleStore store = ConsoleStore.getInstance();
    private final static ShoppingCart sc = new ShoppingCart();

    public static void main(String... args) {
        int code = 1;
        fillStore(store);
        Scanner scanner = new Scanner(System.in);
        while (code != 0) {
            System.out.println(menu);
            code = scanner.nextInt();
            switch (code) {
                case 1:
                    store.printProducts();
                    break;
                case 2:
                    addProduct();
                    break;
                case 3:
                    sc.printShoppingCart();
                    break;
                case 4:
                    sc.makeOrder();
                    break;
                case 5:
                    sc.printLastFiveProducts();
                    break;
                case 6:
                    findOrdersByPeriod();
                    break;
                case 7:
                    chooseOrderSortedByDate();
                    break;
            }
        }
    }

    public static void fillStore(ConsoleStore store) {
        ArrayList<Product> products = new ArrayList<>();
        products.add(new Product("prod1", new BigDecimal("1000"), "Ukraine"));
        products.add(new Product("prod2", new BigDecimal("2000"), "USA"));
        products.add(new Product("prod3", new BigDecimal("500"), "Ukraine"));
        products.add(new Product("prod4", new BigDecimal("800"), "Germany"));
        products.add(new Product("prod5", new BigDecimal("1500"), "France"));

        store.addProducts(products);
    }

    public static void addProduct() {
        System.out.println("Input name of product");
        String name = scanner.nextLine();
        Optional<Product> findProduct = store.findProductByName(name);
        if (findProduct.isPresent()) {
            sc.addProduct(findProduct.get());
            System.out.println("Product was added");
        } else {
            System.out.println("Product was not found");
        }
    }

    public static void findOrdersByPeriod() {
        System.out.println("Input date start");
        Date start = inputDate();
        System.out.println("Input date end");
        Date end = inputDate();
        store.printOrders(start, end);
    }

    public static void chooseOrderSortedByDate() {
        System.out.println("Input date");
        Date date = inputDate();
        Optional<Map.Entry<Date, ShoppingCart>> order = store.getFirstOrderSortedByDate(date);
        order.ifPresent(System.out::println);
    }

    public static Date inputDate() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        boolean flag = true;
        Date date = null;
        while (flag) {
            try {
                date = dateFormat.parse(scanner.nextLine());
                flag = false;
            } catch (ParseException e) {
                System.out.println("Incorrect data value! Input again.");
            }
        }
        return date;
    }
}
