package main.java.day211124_Socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class MyClientTcp {
    public static void main(String[] args) throws IOException {
        //发送信息
        Socket socket = new Socket("127.0.0.1", 8899);
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write("你好".getBytes());

        //返回信息
        InputStream inputStream = socket.getInputStream();

        byte[] bytes = new byte[1024];
        int len = inputStream.read(bytes);
        System.out.println(new String(bytes, 0, len));

       // 关闭资源
        outputStream.close();
        inputStream.close();
        socket.close();

    }
}
