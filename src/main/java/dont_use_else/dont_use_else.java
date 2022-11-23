package dont_use_else;

public class dont_use_else {

    public int getCrewScore(String crew){

        int score = 0;

        if("터틀".equals(crew)){
            score = 0;
        } else {
            score = 10;
        }

        return score;
    }

    //만약 크루원이 50명이면 전부다 분기점을 가져야하는것일까?

    public int getAddedCrewScore(String crew){

        int score = 0;

        if("터틀".equals(crew)){
            score = 0;
        } else if("햄스터".equals(crew)){
            score = 1;
        } else if("골든햄스터".equals(crew)){
            score = 10;
        } else if("드워프햄스터".equals(crew)){
            score = 5;
        } else if("코즈".equals(crew)){
            score = 7;
        }
        /*
         대충 수많은 else if 문의 반복
         .
         .
         .
         .
         .
         .
         .
         .
         .
         */
        else {
            score = 3;
        }


        // 만약에 여기서 score에 대한 추가적인 로직이 있다면?
        // 저위에 긴코드를 쭉 따라가서 올라가봐야할것이다.
        // else 를 제거한다한들 절차지향코드같은 성향을 나타내는것은 변함이 없다.
        // 객체지향적 코드로 변경해보자. --> 한번 enum 을 사용해보자.


        return score;
    }


}
