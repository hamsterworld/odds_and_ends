package WrapAllPrimitivesAndStrings.user2;

public class User2 {

    private Name2 name;
    private Age2 age;

    public User2(Name2 name, Age2 age) {
        this.name = name;
        this.age = age;
    }

}

class Age2 {
    private int age;
    public Age2(String input) {
        age = Integer.parseInt(input);
        if(age < 0){
            throw new IllegalArgumentException("나이가 0이하일순 없습니다.");
        }
    }

}

class Name2 {
    private String name;
    public Name2(String name) {
        if(name.length() < 2){
            throw new IllegalArgumentException("이름은 2글자 이상만 가능합니다.");
        }
        this.name = name;
    }


    /**
     * 책임이 명확해졌다!
     * 이름과 나이값을 포장해서 예외처리라는 동작을 Name,Age가 담당하도록 위임하였다.
     */
}
