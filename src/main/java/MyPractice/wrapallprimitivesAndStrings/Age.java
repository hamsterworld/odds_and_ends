package MyPractice.wrapallprimitivesAndStrings;

import lombok.Getter;

@Getter
public class Age {
    private Integer age;

    public Age(Integer age) {
        this.age = age;
        if(age < 0 || age > 100){
            throw new IllegalArgumentException("나이는 0에서 100사이에서만 입력해주세요.");
        }
    }


}
