package examples.string;

public class StringControl {

    public static void main(String[] args) {

        StringControlLogics sl = new StringControlLogics();

        String str = sl.intToString(123);
        System.out.println("Integer to String        : " + str);

        int num = sl.stringToInt("123");
        System.out.println("String  to Integer       : " + num);

        StringBuilder sbd = sl.stringToBuilder("abc");
        System.out.println("String  to StringBuilder : " + sbd.toString());

        StringBuffer sbf = sl.stringToBuffer("abc");
        System.out.println("String  to StringBuffer  : " + sbf.toString());

    }
}

class StringControlLogics {

    int stringToInt(String str) {
        return Integer.parseInt(str);
    }

    String intToString(int num) {
        return num + "";
    }

    StringBuilder stringToBuilder(String str) {
        return new StringBuilder(str);
    }

    StringBuffer stringToBuffer(String str) {
        return new StringBuffer(str);
    }
}
