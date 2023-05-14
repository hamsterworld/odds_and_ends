package inflearn.section4._04_long_parameter_list._15_remove_flag_argument;

import java.time.LocalDate;

/**
 * 플래그는 보통 함수에 매개변수로 전달해서, 함수 내부의 로직을 분기하는데 사용한다. (switch,if 에 쓰여서 분기를 하는데 쓰는 파라미터를 flag 라고 한다.)
 *
 * 플래그를 사용하는 함수는 차이를 파악하기 힘들다.
 *
 * bookConcert(customer,false), bookConcert(customer,true) => 차이를 알수없다. true,false 가 무엇을 의미? 결국, 내부구현을 살펴볼수밖에없다.
 * bookConcert(customer),premiumBookConcert(customer) => 아 하나는 그냥티켓 하나는 프리미엄티켓이구나.
 *
 * 조건문 분해하기 (Decompose Condition)를 활용할수있다.
 *
 * 결국에는 flag 가 뭘의미하는지 알수있게 한다.
 */
public class Shipment {

//    public LocalDate deliveryDate(Order order, boolean isRush) {
//        if (isRush) {
//            return rushDeliveryDate(order);
//        } else {
//            return regularDeliveryDate(order);
//        }
//    }

    private LocalDate regularDeliveryDate(Order order) {
        int deliveryTime = switch (order.getDeliveryState()) {
            case "WA", "CA" -> 2;
            case "OR", "TX", "NY" -> 3;
            default -> 4;
        };
        return order.getPlacedOn().plusDays(deliveryTime);
    }

    private LocalDate rushDeliveryDate(Order order) {
        int deliveryTime = switch (order.getDeliveryState()) {
            case "WA", "CA", "OR" -> 1;
            case "TX", "NY", "FL" -> 2;
            default -> 3;
        };
        return order.getPlacedOn().plusDays(deliveryTime);
    }

    public static void main(String[] args) {
        LocalDate placeOn = LocalDate.of(2021, 12, 15);
        Order orderFromWA = new Order(placeOn, "WA");

        Shipment shipment = new Shipment();
        //shipment.deliveryDate(orderFromWA,true); // 인텔리제이때메 우리는 true,false 가 뭐하는건지 알수있긴하다.
                                                       // 그만큼 인텔리제이가 스마트하다.

        shipment.rushDeliveryDate(orderFromWA); // => 이렇게 사용한다. 파라미터도줄이고 매서드명도 좀더 명시적으로 만들었다.
    }
}
