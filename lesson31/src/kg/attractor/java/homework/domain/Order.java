package kg.attractor.java.homework.domain;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Comparator.*;
import static java.util.stream.Collectors.toList;

public class Order {
    // Этот блок кода менять нельзя! НАЧАЛО!
    private final Customer customer;
    private final List<Item> items;
    private final boolean homeDelivery;
    private transient double total = 0.0d;

    public Order(Customer customer, List<Item> orderedItems, boolean homeDelivery) {
        this.customer = customer;
        this.items = List.copyOf(orderedItems);
        this.homeDelivery = homeDelivery;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return homeDelivery == order.homeDelivery &&
                Objects.equals(customer, order.customer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(customer, homeDelivery);
    }

    public List<Item> getItems() {
        return items;
    }

    public boolean isHomeDelivery() {
        return homeDelivery;
    }

    public Customer getCustomer() {
        return customer;
    }

    public double getTotal() {
        return total;
    }
    // Этот блок кода менять нельзя! КОНЕЦ!

    //----------------------------------------------------------------------
    //------   Реализация ваших методов должна быть ниже этой линии   ------
    //----------------------------------------------------------------------

    public void setTotal(double total) {
        this.total = total;
    }

    public static void calculateTotal(Order order) {
        order.setTotal(order.items.stream().mapToDouble(Item::getPrice).sum());
    }

    public static void printOrder(List<Order> listOrder){
        listOrder.forEach(e -> e.getItems().forEach(System.out::println));
    }

    public static List<Order> ordersMinSum(List<Order> list){
        return list.stream().
                sorted(comparingDouble(Order::getTotal)).
                limit(10).collect(toList());
    }
    public static List<Order> ordersMaxSum(List<Order> list){
        return list.stream().sorted(comparingDouble(Order::getTotal).
                reversed()).limit(10).collect(toList());
    }

    public static  List<Order> homeDelivery(List<Order> orders){
        var home = orders.stream().filter(Order::isHomeDelivery).collect(toList());
        return home;
    }

    public static  void mostAndLeastOrders(List<Order> orders){
        var sum = orders.stream().min(comparingDouble(Order::getTotal)).get();
        sum.getItems().forEach(System.out::println);
    }

    public static void minMaxOrders(List<Order> orders){
        var test = orders.stream().
                sorted(comparing(Order::getTotal)).
                dropWhile(e -> e.getTotal() < 3.06).
                takeWhile(e -> e.getTotal() < 12.65).toList();
        test.forEach(System.out::println);
    }

    public static void sumOrders(List<Order>  orderList){
        var totalSum = orderList.stream().mapToDouble(Order::getTotal).sum();
        System.out.println(totalSum);
    }


    @Override
    public String toString() {
        return "Order{" +
                "customer=" + customer +
                ", items=" + items +
                ", homeDelivery=" + homeDelivery +
                ", total=" + total +
                '}';
    }
}
