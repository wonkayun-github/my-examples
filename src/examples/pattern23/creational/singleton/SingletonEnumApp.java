package examples.pattern23.creational.singleton;

/*
    Thread-safety와 Serialization이 보장된다.
    Reflection을 통한 공격에도 안전하다.
    따라서 Enum을 이용해서 Singleton을 구현하는 것이 가장 좋은 방법이다.
 */

enum SingletonEnum {
    INSTANCE;

    static SingletonEnum getInstance() { return INSTANCE;}
}

public class SingletonEnumApp {

    public static void main( String[] args ) {

        SingletonEnum e = SingletonEnum.getInstance();
        System.out.println(e.toString());
    }
}

