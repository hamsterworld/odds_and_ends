package inflearn.section8._08_shotgun_surgery._28_inline_function;

/**
 * 함수인라인
 *
 * 함수 추출하기와 정반대의 리팩토링 기법이다.
 * 함수로 추출하여 함수 이름으로 의도를 표현하는 방법이다.
 * 간혹, **[함수 본문이 함수 이름만큼 또는 그보다 더 잘 의도를 표현하는 경우도 있다.]
 *
 * 함수 리팩토링이 잘못된 경우에 여러 함수를 인라인하여 커다란 함수를 만든다음에 다시 함수 추출하기를 시도할수있다.
 *
 */
public class Driver {

    private int numberOfLateDeliveries;

    public Driver(int numberOfLateDeliveries) {
        this.numberOfLateDeliveries = numberOfLateDeliveries;
    }

    public int getNumberOfLateDeliveries() {
        return this.numberOfLateDeliveries;
    }
}
