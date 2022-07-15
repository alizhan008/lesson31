package kg.attractor.java;

 import kg.attractor.java.homework.RestaurantOrders;
 import kg.attractor.java.homework.domain.Item;
 import kg.attractor.java.homework.domain.Order;

 import java.util.ArrayList;
 import java.util.stream.Collectors;

 import static java.util.stream.Collectors.*;
 import static java.util.Comparator.*;

// используя статические imports
// мы импортируем *всё* из Collectors и Comparator.
// теперь нам доступны такие операции как
// toList(), toSet() и прочие, без указания уточняющего слова Collectors. или Comparator.
// вот так было до импорта Collectors.toList(), теперь стало просто toList()


public class Main {

    public static void main(String[] args) {

        // это для домашки
        // выберите любое количество заказов, какое вам нравится.

        var orders = RestaurantOrders.read("orders_100.json").getOrders();
//        Order.printOrder(orders);
//        Order.ordersMinSum(orders).forEach(System.out::println);
//        Order.ordersMaxSum(orders).forEach((System.out::println));
//        Order.homeDelivery(orders).forEach(System.out::println);
//        Order.mostAndLeastOrders(orders);
//        Order.minMaxOrders(orders);
//        Order.sumOrders(orders);

    }
}
