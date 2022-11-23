package demeter.advanced;



/**
 * 불필요한 getter 도 사라졌다.
 */

public class User {

    private String email;
    private String name;
    private Address address;

    public boolean isSeoulUser() {
        return address.isSeoul();
    }
}
