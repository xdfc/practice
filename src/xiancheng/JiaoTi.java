package xiancheng;

import java.util.concurrent.Callable;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 两个线程交替执行输出
 *
 */




class PrintThread {
    public  void onePrint(){
        System.out.println(Thread.currentThread().getName()+"你好");
    }
}

public class JiaoTi {
    public static void main(String[] args) throws Exception{
        int num = 10;
        PrintThread p1 = new PrintThread();
        ReentrantLock l = new ReentrantLock(true);  //公平锁
        new Thread(()->{
            for(int i = 0;i<10;i++){
                l.lock();     //对同一个资源锁住
                p1.onePrint();
                l.unlock();
            }
        },"A").start();
        new Thread(()->{
            for(int i = 0;i<10;i++){
                l.lock();
                p1.onePrint();
                l.unlock();
            }
        },"D").start();
    }

}

