package Unmodifiable_Collection;



import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class unmodifiableCollection {

    //불변객체를 만들때 이것도 안에애들까지 완벽하게 deep copy 가 아니라
    //collection 에 조작매서드가 들어가게되면 exception 을 일으키게된다.
    public static void main(String[] args) {
        ArrayList<Name> originNames = new ArrayList<>();
        originNames.add(new Name("Fafi"));
        originNames.add(new Name("kevin"));

        Collection<Name> names = Collections.unmodifiableCollection(originNames);
        try{
            names.add(new Name("Sally"));
        }catch (UnsupportedOperationException e){
            System.out.println("unsupportedOperationException 발생" + e.getMessage());
        }
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
