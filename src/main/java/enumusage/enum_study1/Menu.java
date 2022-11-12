package enumusage.enum_study1;

/**
 * enum은 컴파일시에 정해진다.
 * 그래서 client 에서 생성할수없다.
 * 직렬화,리플렉션에도 안전하며, singleton pattern 구현에 자주사용된다.
 *
 */
public enum Menu {

    //열거상수가 각 instance 를 참조하고 있다.
    PIZZA(2000){
        public void show(){
            System.out.println("피자의 가격은 " + getValue());
        }
    },BURGER(2500){
        public void show(){
            System.out.println("햄버거의 가격은 " + getValue());
        }
    },COKE(500){
        public void show(){
            System.out.println("쿠키의 가격은 " + getValue());
        }
    };

    int value;
    private Menu(int value){
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    //추상메서드를 사용하면 상수에서 재정의가 가능하므로, enum의 확장성이 증가한다.
    //즉, 상수를 사용할 때 꼭 필요로 하는 메서드를 추가할 수 있다.
    //만약에 각 상수마다 show 를 구현안하면 compile 에러가 뜬다.
    public abstract void show();

}
