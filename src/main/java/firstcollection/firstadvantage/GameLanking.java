package firstcollection;

import java.util.HashMap;
import java.util.Map;

/**
 * 1급 collection또한 종속적인것을 변화시키기위한것이다.
 * 원시타입을 래핑해준것처럼
 * collection또한 래핑해주자.
 */
public class GameLanking {

    private Map<String,String> ranks;

    public GameLanking(Map<String, String> ranks) {
        this.ranks = ranks;
    }

    public static void main(String[] args) {

        HashMap<String, String> map = new HashMap<>();
        map.put("1","A");
        map.put("2","B");
        map.put("3","C");
        //위와같은 코드를 래핑한다.

    }

}
