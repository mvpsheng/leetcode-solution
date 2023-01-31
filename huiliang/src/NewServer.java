import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * FileName: NewServer
 * author: gxs
 * Date: 2021/9/3  7:59
 */
public class NewServer {
    private static int port = 8088;
    private static Socket socket;
    private static ServerSocket serverSocket;
    private static BufferedWriter bufferedWriter;
    static String method;
    static int a;
    static int b;
    static int result = 0;

    public static void main(String[] args) throws Exception {
        serverSocket = new ServerSocket(port);
        System.out.println("Server started......");
        while (true){
            socket = serverSocket.accept();
            InputStreamReader inputStreamReader = new InputStreamReader(socket.getInputStream());
            System.out.println("request success!");
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String readLine = bufferedReader.readLine();
            System.out.println("------------------------");

            System.out.println(readLine);
            String[] split1 = readLine.split(" ");

            if (split1[1].contains("=")){
                //拼接字符串
                split1[1] = split1[1].substring(1);
                String[] calculator = split1[1].split("\\?");
                method = calculator[0];
                String[] numString = calculator[1].split("&");
                String[] aStringArray = numString[0].split("=");
                String[] bStringArray = numString[1].split("=");
                try {
                    a = Integer.parseInt(aStringArray[1]);
                    b = Integer.parseInt(bStringArray[1]);
                }catch (Exception e){
                    Error();
                    System.out.println("Error is "+e.getMessage());
                    continue;
                }
                if (method.equals("add")){
                    result = a + b;
                }else if (method.equals("mult")){
                    result = a * b;
                }else{
                    Error();
                    continue;
                }
                //发送响应请求
                System.out.println("-------------------------");
                System.out.println("send response");
                writeMsg();
            }else{
                System.out.println("-------------------------");
                System.out.println("send response");
                Error();
            }
        }
    }
    public static void writeMsg() throws Exception{
        bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        bufferedWriter.write("HTTP/1.1 200 ok"+"\n\n"+" method "+ method+ "'s result is "+ result);
        bufferedWriter.flush();
        bufferedWriter.close();
    }
    public static void Error() throws Exception{
        bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        bufferedWriter.write("HTTP/1.1 200 error "+"\n\n"+ "Please input in right format");
        bufferedWriter.flush();
        bufferedWriter.close();
    }

}
