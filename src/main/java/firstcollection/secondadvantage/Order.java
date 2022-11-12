package firstcollection.secondadvantage;

import lombok.ToString;

@ToString
public class Order {

    private Long id;
    private String clientName;
    private String product;

    public Order(Long id, String clientName, String product) {
        this.id = id;
        this.clientName = clientName;
        this.product = product;
    }

}
