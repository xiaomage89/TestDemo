package main.java.day211122_Thread;

public class ThreadExtends {
    public static void main(String[] args) {
        new MyThread("Thread测试1").start();
        new MyThread("Thread测试2").start();
        new MyThread("Thread测试3").start();
    }
}

class MyThread extends Thread{

    private String acceptStr;

    public MyThread(String acceptStr) {
        this.acceptStr = acceptStr;
    }

    public void run() {

        for (int i = 0; i < 50; i ++) {
            System.out.println("这个传给我的值："+acceptStr+",加上一个变量，看看是什么效果："+i);
        }
    }
}
