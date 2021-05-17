package examples.pattern23.creational.singleton;

class SingletonInstance {

    private static SingletonInstance singletonInstance = new SingletonInstance();
    private static int age;

    private SingletonInstance() {}

    static SingletonInstance getInstance( int age ) {
        SingletonInstance.age = age;
        return singletonInstance;
    }

    void setAge(int age) { SingletonInstance.age = age; }
    int getAge(){ return age; }

}

public class SingletonStaticApp {

    public static void main(String[] args){

        SingletonInstance si = SingletonInstance.getInstance(30);

        System.out.println(si.getAge());

    }

}
