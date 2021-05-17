package examples.pattern23.structural.decorator.after;

abstract class Display { abstract void draw();}

abstract class DisplayDecorator extends Display {
    private Display decoratedDisplay;
    DisplayDecorator(Display decoratedDisplay) {
        this.decoratedDisplay = decoratedDisplay;
    }

    @Override
    void draw() {
        decoratedDisplay.draw();
    }
}

class RoadDisplay extends Display {

    @Override
    void draw() {
        System.out.println("기본 도로 표시");
    }
}

class LaneDecorator extends DisplayDecorator {
    LaneDecorator(Display decoratedDisplay) { super(decoratedDisplay); }

    @Override
    void draw() {
        super.draw();
        drawLane();
    }

    private void drawLane() { System.out.println("\t차선 표시"); }
}

class TrafficDecorator extends DisplayDecorator {
    TrafficDecorator(Display decoratedDisplay) { super(decoratedDisplay); }

    @Override
    void draw() {
        super.draw();
        drawTraffic();
    }

    private void drawTraffic() { System.out.println("\t교통량 표시"); }
}


public class RoadDisplayAfterApp {

    public static void main(String[] args) {

        Display road = new RoadDisplay();
        road.draw();

        // 이것이 Decorator 패턴!!
        // Decorator 를 둬서 그를 상속하는 여러 객체의 기능을 모두 추가해서 사용할 수 있다.

        Display roadWithLane = new LaneDecorator(new RoadDisplay());
        roadWithLane.draw();

        Display roadWithTraffic = new TrafficDecorator(new RoadDisplay());
        roadWithTraffic.draw();

        Display roadWithLaneWithTraffic = new TrafficDecorator(new LaneDecorator(new RoadDisplay()));
        roadWithLaneWithTraffic.draw();


    }
}
