import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    String[] password = {"123456"};
    PrintWriter writer;
    BufferedReader reader;
    int count = 0;
    boolean ileg = false;
    boolean succ = false;
    public static void main(String[] args)
    {
        new Server().gotos();
    }
    public void gotos()
    {
        try {
            ServerSocket server = new ServerSocket(1244);//端口
            Socket clientSocket = server.accept();//监听请求
            writer = new PrintWriter(clientSocket.getOutputStream());
// 1)向客户端发送"Verifying Server!"
            writer.println("Verifying Server!");
            writer.flush();
            while (true)
            {
                Thread thread = new Thread(new ClientHandle(clientSocket));
                thread.run();
                if (ileg|| succ)
                    break;
            }
        } catch (Exception ex)
        { ex.printStackTrace(); }
    }
    class ClientHandle implements Runnable
    {
        Socket socket;
        public ClientHandle(Socket s)
        {
            try
            {
                socket = s;
                InputStreamReader isReader = new InputStreamReader(socket.getInputStream());
                reader = new BufferedReader(isReader);
                writer = new PrintWriter(socket.getOutputStream());
            }
            catch (Exception ex)
            {ex.printStackTrace();}
        }
        public void run() {
            try {
// 读取客户端发出的指令
                String command = reader.readLine();
                boolean contained = false;
                for (String s:password)
                {
                    if (command.equals(s))
                        contained = true;
                }
// 2)若读口令次数超过3次，则发送Illegal User!给客户端
                if (count > 2) {
                    writer.println("Illegal User!");
                    writer.flush();
                    ileg = true;
                }
                if (contained)
                {
// 若指令正确，输出Registration Successful!
                    writer.println("Registration Successful!");
                    writer.flush();
                    succ = true;
                }
                else
                    {
// 若指令错误，输出PassWord Wrong!
                    writer.println("PassWord Wrong!");
                    writer.flush();
                    count+=1;
                }
            } catch (Exception ex) {ex.printStackTrace();}
        }
    }
}