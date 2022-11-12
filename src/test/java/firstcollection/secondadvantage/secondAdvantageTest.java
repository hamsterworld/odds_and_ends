package firstcollection.secondadvantage;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class secondAdvantageTest {

    @Test
    @DisplayName("final도 값 변경이 가능하다.")
    void secondAdvantage(){

        //given
        final HashMap<String, Boolean> collection = new HashMap<>();

        //when
        collection.put("1",true);
        collection.put("2",true);
        collection.put("3",true);
        collection.put("4",true);
        //map에 값을 추가하는것을 막을 수 없다.

        //then
        assertEquals(collection.size(),4);

    }

    @Test
    @DisplayName("final은 재할당이 불가능하다,")
    void secondAdvantage1(){

        //given
        final HashMap<String, Boolean> collection = new HashMap<>();

        //when
//        collection = new HashMap<>();  --> 컴파일 오류가 난다.

        //then

    }

    /**
     * 그래서 요즘은 불변객체를 만드는것이 너무종요하다.
     * 각각의 객체들의 값이 절대로 바뀔일이 없다는 것을 보장하는것은 side effect를 최소화하기때문이다.
     * 만약에 final collection이 member 객체를 담고있다고 했을때
     * collection.put("오인석").setAge(10);하면 당연히 작동한다. 이는 불변임을 보증할수없다.
     */
    @Test
    @DisplayName("1등급collection은 불변임을 보증할수있다.")
    void secondAdvantage2(){

        //given
        OrderCreateService orderCreateService = new OrderCreateService();
        ClientOrders listOrder = orderCreateService.createListOrder();

        //when
        listOrder.whoIsOrderOnConsole(); // --> 제공해주는 매서드가 이놈뿐이다. 상태는 private되서 접근할수가없다 이래서 함부로 getter,setter쓰지말라는거군.

        //then
        System.out.println(" listorder의 접근할수있는 방법이 없다. = 불변임을 보증한다. " );

    }

}