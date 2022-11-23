package demeter.advanced;

/**
 * demeter 의 법칙을 준수하고 있는 코드이다.
 *
 * demeter 의법칙은 .(도트)를 여러개 사용하지 말라는 것이 아니다. (Stream API 사용하는것을 보면 알수있다.)
 * Client 객체가 다른 객체를 사용할때 어떤 자료형을 가지고있는지 몰라야하며
 * 그냥 자료대신 함수를 공개하도록해라.
 *
 * 여기서 내가알고싶은것은 그저 user가 서울인지아닌지만 중요하지
 * 안에 List가 뭐고 Address가 있고 거기안에 또 get필드하고 그걸또 "서울".equals 하고는 전혀 중요하지않다.
 *
 * 그래서 내부구조를 숨기고 외부에 원하는 것만 노출시키는 것이 중요하다.
 * 노출시키는것은 함수를 통해서만 노출
 *
 * 근데 .(도트)가 여러개로 많아지면 솔직히알아보기도힘들기때문에 의심해보자.
 */
public class NotificationService {

    public void sendMessageForSeoulUser(final User user){
        if(user.isSeoulUser()){
            sendNotification(user);
        }
    }

    private void sendNotification(User user) {

    }

}
