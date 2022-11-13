package enumusage.enum_study6;

/**
 * 어떤 문제가 있는 것일까?
 *  1.둘의 관계를 파악하기 힘들다.
 *  결제종류가 결제수단을 포함하고있는 것인데, 이매소드만 봐서는
 *  확실하게 뭔지모른다.
 *
 *  2.입력값과 결과값의 예측이 불가능하다.
 *  arg와 return 모두 String이므로, String이면 전부 받을수있다.
 *  즉, 값의 검증이 필요하고.
 *  return값을 받는 쪽에서도 또한 검증해야하는 로직이 필요하다.
 *
 *  3.그룹별 기능을 추가하기가 힘들다. --> 이게 결정적이다.
 *  만약에 결제 종류에따른 새로운 기능을 추가해야된다면 어떻게 해야될까?
 *
 *  -이건 tip입니다.
 *  arg에 final은 매서드내에서 재할당을 막습니다.
 *
 *  public String example(final Integer i){
 *      i = 10; <-- 이런거 막음.
 *  }
 */
public class LegacyPayGroup {

    public static String getPayGroup(String payCode){

        if("ACCOUNT_TRANSFER".equals(payCode) || "REMITTANCE".equals(payCode) || "ON_SITE_PAYMENT".equals(payCode) || "TOSS".equals(payCode)){
            return "CASH";
        } else if("PAYCO".equals(payCode) || "CARD".equals(payCode) || "KAKAO_PAY".equals(payCode) || "BAEMIN_PAY".equals(payCode)){
            return "CARD";
        } else if("POINT".equals(payCode) || "COUPON".equals(payCode)){
            return "ETC";
        } else {
            return "EMPTY";
        }
    }

    //3번의 말처럼 결제종류를 분기하는 코드가 필수적으로 등장하게된다.
    //기능 추가할때마다 if문이 계속들어가게된다.
    public void pushByPayGroup(final String payGroupCode){
        if("CASH".equals(payGroupCode)){
            pushCashMethod();
        } else if ("CARD".equals(payGroupCode)){
            pushCashMethod();
        } else if ("ETC".equals(payGroupCode)){
            pushCashMethod();
        } else {
            throw new RuntimeException("PayGroupCode가 없습니다.");
        }
    }

    public void printByPayGroup(final String payGroupCode){
        if("CASH".equals(payGroupCode)){
            doCashMethod();
        } else if ("CARD".equals(payGroupCode)){
            doCashMethod();
        } else if ("ETC".equals(payGroupCode)){
            doCashMethod();
        } else {
            throw new RuntimeException("PayGroupCode가 없습니다.");
        }
    }

    private void doCashMethod() {

    }

    private void pushCashMethod() {

    }

}
