package inflearn.section6._06_mutable_data._20_remove_setting_method;

/**
 * setter 는 제거할것
 *
 * 객체 생성시 처음 설정된 값이 변경될 필요가 없다면 해당값을 설정할수있는 생성자를 만들고
 * 세터를 제거해서 변경될수있는 가능성을 제거해야한다.
 *
 * test 코드에서보면 맨처음 Id가 주입이 되면
 * 더이상 변경될이유가없기에 setId 는 지워주는게 맞다.
 */
public class Person {

    private String name;

    private int id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

//    public void setId(int id) {
//        this.id = id;
//    }
}
