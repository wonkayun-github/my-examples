package examples.pattern23.structural.decorator.before;

class RoadDisplay {
    void draw() { System.out.println("기본 도로 표시");}
}

class RoadDisployWithLane extends RoadDisplay {
    void draw() {
        super.draw();
        drawlane();
    }

    private void drawlane() { System.out.println("\t차선 표시");}
}

public class RoadDisplayBeforeApp {

    public static void main(String[] args) {
        // draw 로 차선을 그린다.
        RoadDisplay roadDisplay = new RoadDisplay();
        roadDisplay.draw();

        // draw 로 차선을 그리고, 추가로 차선표시도 하고 싶을 때
        // class 를 추가해준다.
        RoadDisployWithLane roadDisployWithLane = new RoadDisployWithLane();
        roadDisployWithLane.draw();

        // 추가로 draw에 다른 기능들을 혼합해서 넣고 싶을 때?
        // ex) 기본기능 + 교통량, 기본기능 + 차선표시 + 교통량, 기본기능 + 교차로표시 + 교통량, 기본기능 + 교차로표시 등등
        // 조합별로 class 를 각각이 만들어 주어야 함
        // 즉, 기본기능 + 아무거나(갯수상관없이) 기능추가 하고 싶을 때 패턴이 필요
    }
}
