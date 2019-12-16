/*CommunicationClient.java*/
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    Scanner input;
    Socket clientA;
    BufferedReader reader;
    PrintWriter writer;
    public static void main(String[] args) {
        Client client = new Client();
        client.go();
    }

    public void go() {
        try {
            clientA = new Socket("10.220.10.143",12345);
            input = new Scanner(System.in);
            reader = new BufferedReader(new InputStreamReader(clientA.getInputStream()));
            writer = new PrintWriter(clientA.getOutputStream());
            Thread thread = new Thread(new IncomingReader());
            thread.start();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public class IncomingReader implements Runnable {
        public void run() {
            try {
// 1)读取服务器反馈信息
                String reply = reader.readLine();
// 2)如果反馈信息不是Verifying Server! 则提示Server Wrong! 并退出程序
                if (!reply.equals("Verifying Server!")) {
                    System.out.println("Server Wrong!");
                }
                else {
                    System.out.println(reply);
                    while (true) {
// 3) 输入password
                        System.out.print("Please input the password: ");
                        String password = input.nextLine();
                        writer.println(password);
                        writer.flush();
// 4)读取反馈信息
                        reply = reader.readLine();
// 5)若反馈信息是Illegal User! 则发出提示，退出程序
                        if (reply.equals("Illegal User!")) {
                            System.out.println(reply);
                            break;
                        }
// 6)若反馈信息是PassWord Wrong! 则发出提示，重新输入password
                        else if (reply.equals("PassWord Wrong!")) {
                            System.out.println(reply);
                        }
// 7)输出Registration Successful!
                        else {
                            System.out.println("Registration Successful!");
                            break;
                        }
                    }
                }
                input.close();
            } catch (Exception ex) {ex.printStackTrace();}
        }
    }
}
