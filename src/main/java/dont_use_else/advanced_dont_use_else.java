package dont_use_else;

public class advanced_dont_use_else {

    public static void main(String[] args) {

    }

    public int getCrewScore(String crewName){

        return Crew.formName(crewName).getScore();

    }

    // 좀더 객체지향적으로 변경되었다.
    // 분기문을 줄이고자하는 노력이 객체지향적인 코드를 짜게 만들었다.
    //


}
