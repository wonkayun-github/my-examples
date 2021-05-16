package examples.pattern23.behavioral.observer;

import java.util.LinkedList;
import java.util.List;

enum EnemyStatus { NONE, APPEAR, ATTACK, DISAPPEAR }
interface Heros { void behavior(EnemyStatus stat); }
interface Observer { void update(EnemyStatus stat); }
interface Subject {
    void add(Observer observer);            //옵저버 객체 추가
    void remove(Observer observer);         //옵저버 객체 삭제
    void notifyObservers();                 //옵저버 객체들에게 상태 푸시
    void notifyObserver(Observer observer); //특정객체에게 상태 푸시
}

class CaptainAmerica implements Heros, Observer {

    public CaptainAmerica(Subject team){
        System.out.println("캡틴아메리카 합류");
        team.add(this);

    }

    @Override
    public void behavior(EnemyStatus stat) {
        switch (stat) {
            case NONE: System.out.println("캡틴 아메리카 : 대기중");
            case APPEAR: System.out.println("캡틴 아메리카 : 유니폼 및 방패 착용");
            case ATTACK: System.out.println("캡틴 아메리카 : 효과없음");
            case DISAPPEAR: System.out.println("캡틴 아메리카 : 유니폼 및 방패 해제");
        }
    }

    @Override
    public void update(EnemyStatus stat) {
        this.behavior(stat);
    }
}

class Hulk implements Observer,Heros {

    public Hulk(){};
    public Hulk(Subject team){
        System.out.println("헐크 합류");
        team.add(this);
    }

    @Override
    public void update(EnemyStatus stat) {
        this.behavior(stat);
    }

    @Override
    public void behavior(EnemyStatus stat) {
        switch(stat){
            case NONE: System.out.println("헐크 : 브루스 배너 상태"); break;
            case APPEAR: System.out.println("헐크 : 헐크로 변신"); break;
            case ATTACK: System.out.println("헐크 : 무시함"); break;
            case DISAPPEAR: System.out.println("헐크 : 변신 해제"); break;
        }
    }
}

class Ironman implements Observer,Heros {

    public Ironman(){};
    public Ironman(Subject team){
        System.out.println("아이언맨 합류");
        team.add(this);
    }

    @Override
    public void update(EnemyStatus stat) {
        this.behavior(stat);
    }

    @Override
    public void behavior(EnemyStatus stat) {
        switch(stat){
            case NONE: System.out.println("아이언맨 : 대기중"); break;
            case APPEAR: System.out.println("아이언맨 : 수트 착용"); break;
            case ATTACK: System.out.println("아이언맨 : 해킹당함. 전투불가능 "); break;
            case DISAPPEAR: System.out.println("아이언맨 : 수트 해제"); break;
        }
    }
}

class Vision implements Observer,Heros {

    public Vision(){};
    public Vision(Subject team){
        System.out.println("비전 합류");
        team.add(this);
    }

    @Override
    public void update(EnemyStatus stat) {
        this.behavior(stat);
    }

    @Override
    public void behavior(EnemyStatus stat) {
        switch(stat){
            case NONE: System.out.println("비전 : 대기중"); break;
            case APPEAR: System.out.println("비전 : 전투준비"); break;
            case ATTACK: System.out.println("비전 : 효과없음"); break;
            case DISAPPEAR: System.out.println("비전 : 전투상태 해제"); break;
        }
    }
}

class Watcher implements Observer {
    Subject subject;

    public Watcher(Subject subject){
        this.subject = subject;
        this.subject.add(this);
    }

    public void checkStat(){
        System.out.println("======= 상태체크 ========");
        subject.notifyObserver(this);
    }

    @Override
    public void update(EnemyStatus stat) {
        switch(stat){
            case NONE: System.out.println("(와처 : 대기)"); break;
            case APPEAR: System.out.println("(와처 : 빌런등장 기록)"); break;
            case ATTACK: System.out.println("(와처 : 빌런공격 기록)"); break;
            case DISAPPEAR: System.out.println("(와처 : 빌런제거 기록)"); break;
        }

    }

}

class Avengers implements Subject {
    private List<Observer> heros;
    private EnemyStatus stat;

    public Avengers(){
        System.out.println("어벤져스 창설");
        heros = new LinkedList<Observer>();
    }

    @Override
    public void add(Observer observer) { heros.add(observer); }

    @Override
    public void remove(Observer observer) {
        if(heros.contains(observer))
            heros.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for(Observer hero : heros)
            hero.update(stat);
    }

    @Override
    public void notifyObserver(Observer observer){
        observer.update(stat);
    }

    //상태 변경이 있을 때 옵저버 들에게 알림
    public void setStat(EnemyStatus stat) {
        this.stat = stat;
        notifyObservers();
    }

    public List<Observer> getMembers(){
        return this.heros;
    }
}


public class ObserverAvengersApp {

    public static void main(String[] args) {

        //주제객체 생성
        Avengers avengers = new Avengers();

        //옵저버객체 생성 및 추가
        CaptainAmerica captainAmerica = new CaptainAmerica(avengers);
        Ironman ironman = new Ironman(avengers);
        Hulk hulk = new Hulk(avengers);

        //옵저버가 아닌 객체 생성
        Vision vision = new Vision();

        //와처 객체 생성
        Watcher watcher = new Watcher(avengers);


        //0. 대기상태
        System.out.println("======= 대기상태 ========");
        avengers.setStat(EnemyStatus.NONE);

        //1. 빌런 등장
        System.out.println("======= 빌런 등장 ========");
        avengers.setStat(EnemyStatus.APPEAR);

        //2. 빌런 공격
        System.out.println("======= 빌런 공격 ========");
        avengers.setStat(EnemyStatus.ATTACK);
        // - 옵저버 제거 및 추가
        avengers.remove(ironman);
        avengers.add(vision);

        //3. 빌런 제거
        System.out.println("======= 빌런 제거 ========");
        avengers.setStat(EnemyStatus.DISAPPEAR);

        //4. 와처 상태 체크
        watcher.checkStat();
    }
}
