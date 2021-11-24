package main.java.day211122_Thread;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.UUID;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class InsertExecutors {
    public static void main(String... arg) {

        BatchInsert bi = new BatchInsert();

        //bi.exec();//自动分配需要线程  耗时80s
        //bi.exec(1);//使用单线程 耗时288s
        bi.exec(10);//手动分配需要线程 耗时81s
    }
}

class BatchInsert {
    private final String url = "jdbc:mysql://localhost:3306/test";
    private final String user = "root";
    private final String pwd = "root";
    private final int dataSize = 1000000;//插入数据数量
    private final int dataUnit = 10000;//1个线程处理数据数量

    private Connection getConn() {
        Connection conn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url,user,pwd);
        }catch(Exception e) {
            e.printStackTrace();
        }
        return conn;
    }
    public void exec() {
        final int threadNum = dataSize/dataUnit + 1;
        exec(threadNum);
    }

    public void exec(final int threadNum) {
        ExecutorService excutor = Executors.newFixedThreadPool(threadNum); //使用线程池
        final CountDownLatch cdl = new CountDownLatch(threadNum);//使用计数器
        long st = System.currentTimeMillis();

        for(int k=1;k<=threadNum;k++) {
            final int p = k;
            excutor.execute(new Thread(new Runnable() {
                @Override
                public void run() {
                    Connection con = getConn();
                    try {
                        con.setAutoCommit(false);//关闭自动提交
                        Statement st = con.createStatement();
                        for(int i=1;i<=dataSize/threadNum;i++) {
                            String uuid = UUID.randomUUID().toString();
                            st.addBatch("insert into test select '"+ uuid +"'");
                            if (threadNum==1) {
                                //System.out.println("单线程插入"+uuid);
                                if (i%dataSize==0) {
                                    st.executeBatch();
                                    System.out.println("单线程批量提交"+i+"条");
                                }
                            }else {
                                //System.out.println("线程"+p+"插入"+uuid);
                                if (i%(dataSize/threadNum)==0) {
                                    st.executeBatch();
                                    System.out.println("线程"+p+"批量提交"+i+"条");
                                }
                            }
                        }
                        cdl.countDown();//计数器减一
                        con.commit();
                    } catch (SQLException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    } finally {
                        try {
                            con.close();
                        }catch(SQLException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }));
        }
        excutor.shutdown();//关闭线程池
        try {
            cdl.await();//线程等待
            long ut = System.currentTimeMillis() -st;
            System.out.println(threadNum+"个线程总共耗费时间"+ut/1000+"s("+ut+"ms)");
        }catch(InterruptedException e) {
            e.printStackTrace();
        }
    }
}