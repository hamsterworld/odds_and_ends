package inflearn.section11._11_primitive_obsession._30_repliace_primitive_with_object;

import java.util.List;

public class OrderProcessor {

//    public long numberOfHighPriorityOrders(List<Order> orders) {
//        // 그래서 아래를 보면 이주문의 등급이 급한지 안급한지를 체크하는 로직이 필요한것으로 보인다.
//        return orders.stream()
//                .filter(o -> o.getPriority() == "high" || o.getPriority() == "rush")
//                .count();
//    }

//    public static void main(String[] args) {
//        OrderProcessor orderProcessor = new OrderProcessor();
//        long l = orderProcessor.numberOfHighPriorityOrders(
//                List.of(new Order("low"),
//                        new Order("normal"),
//                        new Order("high"),
//                        new Order("rush")));
//
//        System.out.println(l);
//        // 여기주문에서 이제 급한건 2건이 될것이다.
//    }

    public long numberOfHighPriorityOrders(List<Order> orders) {
        // 그래서 아래를 보면 이주문의 등급이 급한지 안급한지를 체크하는 로직이 필요한것으로 보인다.
        return orders.stream()
                .filter(o -> o.getPriority().higherThan(new Priority("normal")))
                .count();
    }

    // 아까 체이닝으로 살려서 이렇게 아래처럼 살아잇는모습을 볼수있다.
    public static void main(String[] args) {
        OrderProcessor orderProcessor = new OrderProcessor();
        long l = orderProcessor.numberOfHighPriorityOrders(
                List.of(new Order("low"),
                        new Order("normal"),
                        new Order("high"),
                        new Order("rush")));

        System.out.println(l);
        // 여기주문에서 이제 급한건 2건이 될것이다.
    }
}
