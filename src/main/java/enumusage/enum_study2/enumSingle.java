package enumusage.enum_study2;

public enum enumSingle {

    ONLYONE(30,"in seok"){
        public void home(){
            System.out.println("저의 나이와 이름은 " + age + " " + username);
        }
    },
    ONLYTWO(40,"hamster"){
        public void home(){
            System.out.println("저의 나이와 이름은 " + age + " " + username);
        }
    };

    String username;
    int age;

    private enumSingle(int age,String name){
        this.age = age;
        this.username = name;
    }

    public abstract void home();
}
