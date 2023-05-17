package inflearn.section11._11_primitive_obsession._30_repliace_primitive_with_object;

/**
 * 기본형을 객체로 바꾸기
 *
 * 개발초기에는 기본형 (숫자 또는 문자열)으로 표현한 데이터가 나중에는 해당 데이터와 관련있는 다양한 기능을
 * 필요로 하는 경우가 발생한다.
 *
 * ex) 문자열로 표현하던 전화번호의 지역코드가 필요하거나 다양한 포맷을 지원하는경우
 *
 * ex) 숫자로 표현하던 온도의 단위를 변환하는경우.
 *
 * 기본형을 사용한 데이터를 감싸줄 클래스를 만들면, 필요한 기능을 추가할수있다.
 *
 */
public class Order {

//    private String priority;
//
//    public Order(String priority) {
//        this.priority = priority;
//    }
//
//    public String getPriority() {
//        return priority;
//    }

//    private String priority;

    private final Priority priority;

    // 아래는 체이닝이다.
    // 기존 생성자를 살리고싶을때 이런방법도 있다.
    public Order(String value) {
        this(new Priority(value));
    }

    public Order(Priority priority) {
        this.priority = priority;
    } // 원래 이렇게만해줘도 크게 상관은 없다.

    public Priority getPriority() {
        return priority;
    }
}
