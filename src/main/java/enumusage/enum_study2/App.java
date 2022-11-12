package enumusage.enum_study2;

public class App {

    public static void main(String[] args) {
        enumSingle onlyone = enumSingle.ONLYONE;
        enumSingle onlyone1 = enumSingle.ONLYONE;

        int age = onlyone.age;
        String name = onlyone.username;
        System.out.println(onlyone.name());

        //singleton 보장
        System.out.println(onlyone == onlyone1);
        onlyone.home();
        System.out.println();

    }
}
