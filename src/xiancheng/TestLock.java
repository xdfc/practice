package xiancheng;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author 007
 * @ClassName 类名称
 * @Description 类描述
 */

 class LockDemo implements Runnable {

    // 定义一个数用来交替更改数字的正负号
    private int j = 1;
    // 定义公平锁,用来是线程1和线程2交替执行
    ReentrantLock lock = new ReentrantLock(true);

    @Override
    public void run() {
        for(int i = 1; i < 10; i++){
            //获取锁
            lock.lock();
 //           try{
                System.out.println(Thread.currentThread().getName()+" "+i*j);
                j=-j;
 //           }finally{
                //释放锁
                lock.unlock();
 //           }
        }
    }

}



/**
 * @author 007
 * @ClassName 类名称
 * @Description 类描述
 */

public class TestLock {
    public static void main(String[] args) {
        //创建对象
        LockDemo lockDemo = new LockDemo();
        //创建两个线程,启动两个线程
        new Thread(lockDemo,"线程1").start();
        new Thread(lockDemo,"线程2").start();
    }
}
