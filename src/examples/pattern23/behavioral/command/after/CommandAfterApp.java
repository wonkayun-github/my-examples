package examples.pattern23.behavioral.command.after;

interface Command { abstract void excute(); }

class LampOnCommand implements Command {
    private Lamp lamp;
    LampOnCommand( Lamp lamp ) { this.lamp = lamp; }

    public void excute() { lamp.turnOn(); }
}

class AlarmCommand implements Command {
    private Alarm alarm;
    AlarmCommand( Alarm alarm ) { this.alarm = alarm; }

    public void excute() { alarm.start(); }
}

class Button {
    private Command command;
    Button( Command command ) { setCommand(command); }
    void setCommand( Command command ) { this.command = command; }
    void press() { command.excute(); }
}

class Alarm {
    void start() { System.out.println("Alarming!"); }
}

class Lamp {
    void turnOn() { System.out.println("Turn On!"); }
}

public class CommandAfterApp {

    public static void main( String[] args ) {

        Lamp lamp = new Lamp();
        Alarm alarm = new Alarm();
        Command lampOnCommand = new LampOnCommand(lamp);
        Command alarmCommand = new AlarmCommand(alarm);

        Button button = new Button(lampOnCommand);
        button.press();

        button.setCommand(alarmCommand);
        button.press();

        // Strategy 패턴과 다른점은 수행하고자 하는 매소드명이 다르다.
        // Alarm.start(), Lamp.trunOn()  그리고 둘 사이에 아무런 관계가 없다
        // 아무런 관계가 없는 두 메소드를 묶어주고, 하나의 메소드(press) 호출로 두 메소드 호출을 컨트롤 한다.
    }
}
