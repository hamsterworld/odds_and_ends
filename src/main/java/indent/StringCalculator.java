package indent;

/**
 * 첫번째, indent 는 되도록이면 1을 유지할것. --> 매서드로 변경하라는 말
 * 두번째, else 는 사용하지 않는다. -->
 *
 */
public class StringCalculator {

    public static int splitAndSum(String text){

        int result = 0;

        if(text == null || text.isEmpty()){
            result = 0; //이게 하나의 indent 1이다.
        } else { // else 예약어를 쓰지않는다.
            String[] values = text.split(",|:");
            for(String value : values){
                result += Integer.parseInt(value); //indent 2
            }
        }

        return result;
    }

}
