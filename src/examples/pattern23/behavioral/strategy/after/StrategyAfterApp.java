package examples.pattern23.behavioral.strategy.after;

interface AttackStrategy { public void attack(); }
class ConcreteMissileAttack implements AttackStrategy {
    public void attack() { System.out.println("Attack by Missile"); }
}
class ConcretePunchAttack implements AttackStrategy {
    public void attack() { System.out.println("Attack by Punch!"); }
}

abstract class Robot {
    private AttackStrategy attackStrategy;
    public void attack() { attackStrategy.attack(); }
    public void setAttackStrategy(AttackStrategy attackStrategy) { this.attackStrategy = attackStrategy; }
}
class TaekwonV extends Robot {}
class Atom extends Robot {}

public class StrategyAfterApp {
    public static void main( String[] args ) {

        TaekwonV taekwonV = new TaekwonV();

        taekwonV.setAttackStrategy(new ConcreteMissileAttack());
        taekwonV.attack();

        //Punch로 변경
        taekwonV.setAttackStrategy(new ConcretePunchAttack());
        taekwonV.attack();

        // Missile 을 Punch 로 Method 수정없이 변경하였다.
        // 이것이 Strategy Pattern!

        // 정리하자면, 서로다른 오브젝트가 동일한 메소드를 수행하는 경우
        // 동일한 메소드명을 수행하지만, 서로다른 동작을 하도록 하고싶은 경우 사용하는 패턴이다.

    }
}
