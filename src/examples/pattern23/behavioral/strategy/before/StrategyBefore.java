package examples.pattern23.behavioral.strategy.before;

abstract class Robot { public abstract void attack(); }

class TaekwonV extends Robot {

    public void attack() { System.out.println("Attack by Missile"); }
}

class Atom extends Robot {

    public void attack() { System.out.println("Attack by Punch"); }
}

public class StrategyBefore {

    public static void main( String[] args ) {

        TaekwonV taekwonV = new TaekwonV();
        Atom atom = new Atom();

        taekwonV.attack();

        // 여기서, 태권브이의 attack 을 Punch 로 변경하고싶을 때, TaekwonV.attack() 을 수정해야한다.
        // 이는 SOLID 원칙 중 OCP(Open-Closed Principle, 개방-폐쇄 원칙)에 위배된다.
        // OCP 란, 기능추가 OK, 기능수정 NO.
    }
}
