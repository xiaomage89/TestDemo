package main.java.day211124_Socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author majj
 * @create 2021-11-24 13:56
 */
public class MyServerTcp {
    public static void main(String[] args) throws IOException {
        // 接受信息
        ServerSocket serverSocket = new ServerSocket(8899);
        Socket accept = serverSocket.accept();
        InputStream inputStream = accept.getInputStream();
        byte[] bytes = new byte[1024];
        int len = inputStream.read(bytes);
        System.out.println(new String(bytes,0,len));

        //    發送信息
        OutputStream outputStream = accept.getOutputStream();
        outputStream.write("服务器接受成功".getBytes());

        // 关闭服务
        inputStream.close();
        outputStream.close();
        accept.close();
        serverSocket.close();
    }
}

