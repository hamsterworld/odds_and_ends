package inflearn.section6._06_mutable_data._19_separate_query_from_modifier;

import java.util.List;

public class Criminal {

    // 조회하는 부분이랑 sideEffect(데이터변경) 부분이랑 같이 들어있다.
    // 그래서 조회부분과 데이터변경부분을 분리해보자.
//    public String alertForMiscreant(List<Person> people) {
//        for (Person p : people) {
//            if (p.getName().equals("Don")) {
//                setOffAlarms(); // sideEffect
//                return "Don";
//            }
//
//            if (p.getName().equals("John")) {
//                setOffAlarms(); // sideEffect
//                return "John";
//            }
//        }
//
//        return "";
//    }


    public void alertForMiscreant(List<Person> people) {
        if(!findMiscreant(people).isBlank())
            setOffAlarms();
    }

    public String findMiscreant(List<Person> people) {
        for (Person p : people) {
            if (p.getName().equals("Don")) {
                return "Don";
            }

            if (p.getName().equals("John")) {
                return "John";
            }
        }

        return "";
    }

    private void setOffAlarms() {
        System.out.println("set off alarm");
    }
}
