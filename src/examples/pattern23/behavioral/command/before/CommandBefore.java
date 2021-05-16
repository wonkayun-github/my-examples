package examples.pattern23.behavioral.command.before;

class Lamp {
    void turnOn() { System.out.println("Turn On!"); }
}

class Alarm {
    void start() { System.out.println("Alarming!"); }
}

class Button {

    private Lamp lamp;
    Button(Lamp lamp) { this.lamp = lamp; }
    void pressed() { lamp.turnOn(); }
}

public class CommandBefore {

    public static void main( String[] args ) {
        Lamp lamp = new Lamp();
        Button button = new Button(lamp);
        button.pressed();

        // 버튼을 누르면 알람을 울리게 하고 싶을 때
        // Button class 내부를 Alarm 에 맞추어 수정해야 한다. OCP 에 위배됨.
        // Button.pressed 전체를 변경해야 한다.
        
        // 즉, pressed 버튼 하나로 내가 원하는 여러가지 기능을 수행하고자 하는 경우

    }
}
