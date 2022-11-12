package firstcollection.secondadvantage;


import lombok.ToString;

import java.util.List;

/**
 * 1급컬렉션은 collection의 불변 또한 보장한다.
 * final은 안되나요? final은 재할당이 안되는거지 불변을 보장하지않는다.
 */
public class ClientOrders {

    private final List<Order> orders;

    public ClientOrders(List<Order> orders) {
        this.orders = orders;
    }

    public void whoIsOrderOnConsole(){
        orders.stream().forEach(System.out::println);
    }

}
