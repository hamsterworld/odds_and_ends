package inflearn.section14._14_lazy_elements._34_collapse_hierarchy;

/**
 * 계층합치기
 *
 * 상속구조를 리팩토링하던중에 기능을 올리고 내리다보면
 * 하위클래스와 상위 클래스가 차이가 없는경우에 둘을 합칠수있다.
 * 하위클래스와 상위클래스중 어떤것을 없애야하는가?
 * (둘중에 이름이 더적절한쪽, 둘다 애매하면 어느쪽이든 상관없다.)
 */
public class CourtReservation extends Reservation {

    private String courtNumber;

}
