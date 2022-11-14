package firstcollection.secondadvantage;

import java.util.ArrayList;
import java.util.List;

public class OrderCreateService {

    public ClientOrders createListOrder(){
        ClientOrders clientOrders = new ClientOrders(orderCreated());
        return clientOrders;
    }

    public List<Order> orderCreated(){
        List<Order> orderList = new ArrayList<>();
        orderList.add(new Order(1L,"오인석","Hamster Feed"));
        orderList.add(new Order(2L,"아무개","Table"));
        orderList.add(new Order(3L,"골든이","Hot dog"));
        return orderList;
    }


}
