package main.java.day211123_IO.Demo01ObjectOutputStream;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Demo01ObjectOutputStream {
    public static void main(String[] args) {
        Employee e=new Employee();
        e.name = "zhangsan";
        e.address = "beiqinglu";
        e.age = 20;
        try {
            // 创建序列化流对象
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("employee.txt"));
            // 写出对象
            out.writeObject(e);
            // 释放资源
            out.close();
            System.out.println("Serialized data is saved");

            // 姓名，地址被序列化，年龄没有被序列 化。
            } catch(IOException i)   {
                i.printStackTrace();
            }
        }
    }