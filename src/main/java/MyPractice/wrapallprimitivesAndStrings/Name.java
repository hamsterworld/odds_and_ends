package MyPractice.wrapallprimitivesAndStrings;

import lombok.Getter;

@Getter
public class Name {

    private String name;

    public Name(String name) {
        this.name = name;
        if(name.length() > 5 ){
            throw new IllegalArgumentException("이름은 5글자를 초과할수없습니다.");
        }
    }

}
