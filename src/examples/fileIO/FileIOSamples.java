package examples.fileIO;

import java.io.*;
import java.util.Scanner;

public class FileIOSamples {

    private static final String filepath = "E:\\IntelliJ IDEA\\IdeaProjects\\my-examples\\src\\examples\\file";

    public static void main ( String[] args ) throws IOException {

        FileIOSamples fs = new FileIOSamples();

        // fs.fileInputByStreamChar();
        // fs.fileInputByStreamByte();
        // fs.fileInputByScanner();
        // fs.fileOutputByStream();
        // fs.fileOutputByScanner();
        // fs.fileInOutByStream();
        fs.fileInOutByScanner();
        // fs.fileInputTest();
        // fs.fileInputStreamTest();

    }

    void fileInputByStreamChar() throws IOException {

        FileInputStream fis = new FileInputStream(filepath + File.separator + "abc.txt");

        System.out.println("***** fileInput by Stream Char *****");

        int n;
        String str = "";

        while((n = fis.read()) != -1 ) {
            str = str + (char)n;
        }

        System.out.println(str);

        fis.close();
    }

    void fileInputByStreamByte() throws IOException {

        FileInputStream fis = new FileInputStream(filepath + File.separator + "abc.txt");

        System.out.println("***** fileInput by Stream Byte *****");

        int ch;
        byte[] bt = new byte[1024];

        int i = 0;
        while((ch = fis.read()) != -1 ) {
            bt[i] = (byte)ch;
            i++;
        }

        System.out.print(new String(bt));
        System.out.println();

        fis.close();
    }

    void fileInputByScanner() throws IOException {

        File f = new File(filepath + File.separator + "abc.txt");
        Scanner sc = new Scanner(f);

        System.out.println("***** fileInput by Scanner *****");

        String str = "";
        while(sc.hasNextLine()) {
            str += sc.nextLine();
            if(sc.hasNextLine()) {
                str += "\n";
            }
        }
        System.out.print(str);
        sc.close();
    }

    void fileOutputByStream() throws IOException{

        FileOutputStream fo = new FileOutputStream(filepath + File.separator + "abc_out.txt");

        System.out.println("***** fileOutput by Stream *****");

        int ch;

        while((ch = System.in.read()) != 13){
            fo.write((byte)ch);
        }

        fo.close();

    }

    void fileOutputByScanner() throws IOException {

        Scanner sc = new Scanner(System.in);
        FileWriter fw = new FileWriter(filepath + File.separator + "abc_out.txt");

        System.out.println("***** fileOutput by Scanner *****");

        String str;
        while(!(str = sc.nextLine()).equals(""))
            fw.write(str + "\r\n");

        fw.close();

    }

    void fileInOutByStream() throws IOException {

        FileInputStream fis = new FileInputStream(filepath + File.separator + "abc.txt");
        FileOutputStream fos = new FileOutputStream(filepath + File.separator + "abc_out.txt");

        System.out.println("***** file InOut by Stream *****");

        int ch;
        byte[] tmp = new byte[1024];
        int i = 0;

        while((ch = fis.read()) != -1) {

            tmp[i++] = (byte) ch;
            fos.write((byte) ch);
        }

        System.out.println("현재 읽어온 text :: " + new String(tmp));

        fis.close();
        fos.close();
    }

    void fileInOutByScanner() throws IOException {

        File f = new File(filepath + File.separator + "abc.txt");
        Scanner sc = new Scanner(f);
        FileWriter fw = new FileWriter(filepath + File.separator + "abc_out.txt");

        System.out.println("***** file InOut by Scanner *****");

        String str = "";

        while(!(str = sc.nextLine()).equals("")) {

            System.out.println(str);
            fw.write(str + "\r\n");

            if(!sc.hasNextLine())
                break;
        }

        fw.close();

    }

    void fileInputStreamTest() throws IOException {

        FileInputStream fis = new FileInputStream(filepath + File.separator + "abc.txt");

        int n;
        String str = "";
        byte[] bt = new byte[1024];

        int i=0;
        while(true) {

            n = fis.read();

            if (i > 500) break;
            if (n == -1) break;

            bt[i] = (byte)n;

            str = str + bt[i];

            i++;

        }

        System.out.println(str);
        System.out.println(new String(bt));

    }
}
