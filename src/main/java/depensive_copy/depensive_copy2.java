package depensive_copy;

import java.util.ArrayList;
import java.util.List;

public class depensive_copy2 {

    public static void main(String[] args) {
        ArrayList<Name> originNames = new ArrayList<>();
        originNames.add(new Name("Fafi"));
        originNames.add(new Name("kevin"));

        Names names = new Names(originNames);
        originNames.add(new Name("Sally")); //변경 불가능 List 의 주소값이 변경됬기때문이다.
        System.out.println(names);
    }

    static class Name{
        private final String name;

        public Name(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "Name{" +
                    "name='" + name + '\'' +
                    '}';
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
    }
}
