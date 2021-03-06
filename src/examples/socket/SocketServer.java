package examples.socket;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
// 서버 클래스
public class SocketServer {
    // 버퍼 사이즈 설정
    private final static int BUFFER_SIZE = 1024;
    // 실행 함수
    public static void main(String[] args) {
// 서버 인스턴스 생성 (프로그램이 종료 될때 자동 close)
        try (ServerSocket server = new ServerSocket()) {
// 9999 포트에 서버를 대기 시킨다.
            InetSocketAddress ipep = new InetSocketAddress(9999);
// 서버 인스턴스에 소켓 정보 bind
            server.bind(ipep);
// 콘솔 출력
            System.out.println("Initialize complate");
// 클라이언트로 부터 메시지를 대기하는 스래드 풀
            ExecutorService receiver = Executors.newCachedThreadPool();
// 클라이언트 리스트
            List<Socket> list = new ArrayList<>();
// 서버는 무한 대기
            while (true) {
                try {
// 클라이언트로 부터 접속 대기한다.
                    Socket client = server.accept();
// 클라이언트 리스트에 추가한다.
                    list.add(client);
// 접속 정보 콘솔 출력
                    System.out.println("Client connected IP address =" + client.getRemoteSocketAddress().toString());
// 클라이언트 스래드 풀 시작
                    receiver.execute(() -> {
// client가 종료되면 소켓을 close한다.
// OutputStream과 InputStream를 받는다.
                        try (Socket thisClient = client;
                             OutputStream send = client.getOutputStream();
                             InputStream recv = client.getInputStream();) {
// 메시지 작성
                            String msg = "Welcome server!\r\n>";
// byte 변환
                            byte[] b = msg.getBytes();
// 클라이언트로 전송
                            send.write(b);
// 버퍼
                            StringBuilder sb = new StringBuilder();
// 메시지 대기 루프
                            while (true) {
// 버퍼 생성
                                b = new byte[BUFFER_SIZE];
// 메시지를 받는다.
                                recv.read(b, 0, b.length);
// byte를 String으로 변환
                                msg = new String(b);
// 버퍼에 메시지 추가
                                sb.append(msg.replace("\0", ""));
// 메시지가 개행일 경우 (클라이언트에서 엔터를 친 경우)
                                if (sb.length() > 2 && sb.charAt(sb.length() - 2) == '\r' && sb.charAt(sb.length() - 1) == '\n') {
// 메시지를 String으로 변환
                                    msg = sb.toString();
// 버퍼 비우기
                                    sb.setLength(0);
// 메시지 콘솔 출력
                                    System.out.println(msg);
// exit 메시지일 경우 메시지 대기 루프를 종료한다.
                                    if ("exit\r\n".equals(msg)) {
                                        break;
                                    }
// echo 메시지 작성
                                    msg = "echo : " + msg + ">";
// byte로 변환
                                    b = msg.getBytes();
// 클라이언트로 전송
                                    send.write(b);
                                }
                            }
                        } catch (Throwable e) {
// 에러 발생시 콘솔 출력
                            e.printStackTrace();
                        } finally {
// 접속이 종료되면 접속 정보를 콘솔 출력
                            System.out.println("Client disconnected IP address =" + client.getRemoteSocketAddress().toString());
                        }
                    });
                } catch (Throwable e) {
// 에러 발생시 콘솔 출력
                    e.printStackTrace();
                }
            }
        } catch (Throwable e) {
// 에러 발생시 콘솔 출력
            e.printStackTrace();
        }
    }
}
