package Comparator;

/**
 * Comparator 와 Comparable 은 모두 interface 이다.
 * 실질적인 구현은 compare(T o1,T o2)
 *
 * 왜 구현해? = 객체를 비교할수있게만든다.
 * primitive type 은 쉽게 구별가능
 *
 * but Object 같은것은 구분 불가능 그기준을 정해줘야한다.
 *
 * 그래서 저 2개의 interface 를 통해서 기준을 정해줘서 비교할수있게해준다.
 * (개인적으로 그냥 새로운 기준을 잡아서 비교해준다는게 편한듯? 그중에서 객체를 비교할수있게해주는거같고)
 *
 * Comparable 자기자신과비교 Comparator 파라미터로 들어오는 2개를 비교한다.
 *
 */
public class Comparator {
}
