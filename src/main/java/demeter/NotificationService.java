package demeter;

/**
 * demeter 의 법칙을 위반하고 있는 코드이다.
 *
 * Client 객체가 다른 객체를 지나치게 많이 알게되면 결합도가 높아진다 = 의존성이 높아지게된다.
 * 이게 무슨말이냐면
 * user 에서 getRegion 이라는 자료를 가져오게되면 예를들어서 서울을 검사하게 하고싶으므로,
 * "서울".equals ... 이렇게 종속적인 코드가 된다. 의존성이 높아지게된다.
 *
 * 의존성이 높아진다라는말은 결국 이 객체로인해서 무조건적으로 파생되는 코드가 있다는 말이다.
 * 만약에 Region 이라는 자료구조를 알게됨으로써 이 service class 에서 추가적으로 처리해줘야할 작업이 있다면?
 * 그거면 그거대로 작업을처리하게해줘야한다. 물론 여기서는 조건문이라 추가적인 로직은 안들어갈수있지만.
 *
 * firstCollections 에서도 비슷한게나온다.
 * 만약에 Lotto ticket 이 가짜인지 아닌지 service 가 있다고 생각해보자
 * LottoTicket.getNumber(); 이렇게 받아온후
 * List<Long>을 알게되면 List 에 관해서 validation code 가 필요하게된다.
 * service 에서는 필연적인 코드가된다. 종속적이된다. 결합도가 높아진다. 객체지향적이지 못하다.
 * 비슷한 원리인듯?
 */
public class NotificationService {

    public void sendMessageForSeoulUser(final User user){
        if("서울".equals(user.getAddress().getRegion())){
            sendNotification(user);
        }
    }

    private void sendNotification(User user) {

    }

}
