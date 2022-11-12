package WrapAllPrimitivesAndStrings.user;

public class User {

    private int age;

    public User(String input) {
        int age = Integer.parseInt(input);
        if(age <  0){
            throw new RuntimeException("나이는 0살부터 시작합니다.");
        }
        this.age = age;
    }

    /**
     *  이러면 무슨문제?
     *  문제없잖아
     *  가장 큰 문제: age의 나이값 Validation을 User 객체에서 하게된다.
     *  지금은 age밖에없어서 문제가 없어보인다. 그러나 더추가해보자.
     */
    private String name;

    public User(String nameValue, String ageValue) {
        int age = Integer.parseInt(ageValue);
        validateAge(age);
        validateName(nameValue);
        this.name = nameValue;
        this.age = age;
    }

    private void validateName(String name) {
        if (name.length() < 2) {
            throw new RuntimeException("이름은 두 글자 이상이어야 합니다.");
        }
    }

    private void validateAge(int age) {
        if (age < 0) {
            throw new RuntimeException("나이는 0살부터 시작합니다.");
        }
    }

    /**
     * User객체가 할일이 늘어낫다.
     * User객체는 사용자 그자체의 상태만 관리하면 좋은데 예외처리같은 자잘자잘한 역할도 늘어낫다.
     *
     * 이제 래퍼를 해서 어떤 이점이 있는지 확인해보자.
     */

}
