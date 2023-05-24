package inflearn.section21._21_alternative_classes_with_different_interfaces;

/**
 * alertService 와 EmailService 가 비슷한 기능을 하지만
 * 다른 interface 에 다른 method 이름으로 되어있다.
 * 우리는 개발할때보면 이런 interface 들을 수정할수없는 경우가 있다.
 * 그래서 이 interface 를 맞춰주기위해
 * NotificationService Interface 를 만든다.
 * 이렇게해서 NotificationService 라는 interface 로 한번더 감싸서
 * 보내게되서 method 통일성을 가지게된다.
 */
public class AlertMessage {

    public void setMessage(String message) {

    }

    public void setFor(String email) {

    }
}
