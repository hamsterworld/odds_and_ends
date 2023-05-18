package _11_primitive_obsession._30_repliace_primitive_with_object;

import inflearn.section11._11_primitive_obsession._30_repliace_primitive_with_object.Order;
import inflearn.section11._11_primitive_obsession._30_repliace_primitive_with_object.OrderProcessor;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class OrderProcessorTest {

    @Test
    void numberOfHighPriorityOrders() {
        OrderProcessor orderProcessor = new OrderProcessor();
        long highPriorityOrders = orderProcessor.numberOfHighPriorityOrders(
                List.of(new Order("low"),
                        new Order("normal"),
                        new Order("high"),
                        new Order("rush")));
        assertEquals(2, highPriorityOrders);
    }

}