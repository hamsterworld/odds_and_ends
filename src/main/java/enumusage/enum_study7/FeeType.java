package enumusage.enum_study7;

/**
 * DB 에서 관리하던 이런 코드들을 객체에서도 관리할수있게 Enum 을 사용해서 변경해준것이다.
 * 원래는 FeeType이런거 가져올려면 DB나 다른 저장형태에서 가져와야하지만,
 * 이렇게 Enum 을 통해서 효율적으로(?) 관리할수있다.
 */
public enum FeeType implements EnumMapperType {

    PERCENT("정율"),
    MONEY("정액");

    private String title;

    FeeType(String title){
        this.title = title;
    }

    @Override
    public String getCode() {
        return name();
    }

    @Override
    public String getTitle() {
        return title;
    }
}
