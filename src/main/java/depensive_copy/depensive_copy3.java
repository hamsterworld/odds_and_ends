package depensive_copy;

import java.util.ArrayList;
import java.util.List;

public class depensive_copy3 {

    public static void main(String[] args) {
        ArrayList<Name> originNames = new ArrayList<>();

        Name fafi = new Name("Fafi");
        Name kevin = new Name("kevin");

        originNames.add(fafi);
        originNames.add(kevin);

        Names names = new Names(originNames);
        originNames.add(new Name("Sally")); //방어적복사는 깊은복사는 아니다. 내부까지 전부 ref 가 변경되야하기때문이다.
        System.out.println(names);

        fafi.setName("hamster");
        System.out.println(names); //깊은 복사가 아니므로 변경된다.


        Name kevin1 = names.getName(1); //만약에 Names 가 N번재 index 를 반환하는 getter 가있다면?
        kevin1.setName("golden");
        System.out.println(names);

        //결론 그래서 내부 Name 또한 final 을넣어주든 어떻게든 불변으로 만들어주어야한다.
    }

    static class Name{
        private String name;

        public Name(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "Name{" +
                    "name='" + name + '\'' +
                    '}';
        }

        public String setName(String name){
            return this.name = name;
        }
    }

    static class Names{
        private final List<Name> names;
        //방어적복사
        public Names(List<Name> names) {
            this.names = new ArrayList<>(names);
        }

        @Override
        public String toString() {
            return "Names{" +
                    "names=" + names +
                    '}';
        }

        public Name getName(int index) {
            return this.names.get(index);
        }

    }
}
