package depensive_copy;

import java.util.ArrayList;
import java.util.List;

public class depensive_copy {

    public static void main(String[] args) {
        ArrayList<Name> originNames = new ArrayList<>();
        originNames.add(new Name("Fafi"));
        originNames.add(new Name("kevin"));

        Names names = new Names(originNames);
        originNames.add(new Name("Sally")); //변경 가능 왜냐? 주소값을 공유하고있다.
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

        public Names(List<Name> names) {
            this.names = names;
        }

        @Override
        public String toString() {
            return "Names{" +
                    "names=" + names +
                    '}';
        }
    }
}
