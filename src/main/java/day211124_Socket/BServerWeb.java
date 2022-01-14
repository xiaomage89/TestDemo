package main.java.day211124_Socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author majj
 * @create 2021-11-24 15:48
 * 启动服务器  打开IE浏览器  http://localhost:8866/web/index.html   B/S结构
 */
public class BServerWeb {
    public static void main(String[] args) throws IOException {
        // 接受信息
        ServerSocket serverSocket = new ServerSocket(8866);
        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("===========================");
            new Thread(new Runnable() {
                @Override
                public void run() {
                    BufferedReader bufferedReader = null;
                    FileInputStream fileInputStream = null;
                    OutputStream outputStream = null;
                    try {


                        // 打印web请求信息
                        // InputStream inputStream = socket.getInputStream();
                        // byte[] bytes = new byte[1024];
                        // int len = 0;
                        // while ((len = inputStream.read(bytes)) != -1) {
                        //     System.out.println(new String(bytes,0,len));
                        // }

                        bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                        String readLine = bufferedReader.readLine();
                        String[] split = readLine.split(" ");
                        String path = split[1].substring(1);
                        System.out.println(path);

                        // 读取html文件
                        // http://localhost:8866/web/index.html
                        // FileInputStream fileInputStream = new FileInputStream("web\\index.html");
                        fileInputStream = new FileInputStream(path);

                        // 向浏览器会写数据
                        outputStream = socket.getOutputStream();
                        outputStream.write("HTTP/1.1 200 OK\r\n".getBytes());
                        outputStream.write("Content‐Type:text/html\r\n".getBytes());
                        outputStream.write("\r\n".getBytes());
                        byte[] bytes = new byte[1024];
                        int len = 0;
                        while ((len = fileInputStream.read(bytes)) != -1) {
                            outputStream.write(bytes, 0, len);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }finally {
                        try {
                            bufferedReader.close();
                            fileInputStream.close();
                            outputStream.close();
                            socket.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                    }
                }
            }).start();
        }

    }


}
