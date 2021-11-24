package main.java.day211123_IO.Demo01ObjectOutputStream;


public class Employee implements java.io.Serializable {
    public String name;
    public String address;
    public transient int age;
    // transient瞬态修饰成员,不会被序列化
    public void addressCheck() {
        System.out.println("Address  check : " + name + " ‐‐ " + address);
    }

}
