package demeter.advanced;


/**
 * 불필요한 getter 도 사라졌다.
 */
public class Address {

    private String region;
    private String details;

    public boolean isSeoul() {
        return "서울".equals(region);
    }
}
