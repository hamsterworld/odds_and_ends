package enumusage.enum_study;

/**
 * enum은 언제?
 * 1.연관된 상수를 사용하고싶을때
 * 2.
 */
public class enumStudy {

    private static final String MALE = "MALE";
    private static final String FEMALE = "FEMALE";

    public static void main(String[] args){

        String gender;

        gender = enumStudy.FEMALE;
        gender = enumStudy.MALE;
        gender = "HAMSTER";

        //String type이라
        //굳이 저거아니여도 다른게 들어갈수있다.
        //Hamster가 들어가도 아무문제없다.
    }


}
