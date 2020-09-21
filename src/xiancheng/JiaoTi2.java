package xiancheng;

/**
 * 两个线程交替打印
 */

class PrintThread1 {
    int i = 0;
    int flag = 1;
    public synchronized void onePrint(){
        while(flag!=1){
            try{
                wait();
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        System.out.println("你好"+(i++));
        notify();  //唤起线程2
        flag = 2;
    }
    public synchronized void twoPrint(){
        while(flag!=2) {   //1不等于2 ，所以这个线程等待
            try {
                wait();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        System.out.println("hello"+(i++));
        notify();   //唤起线程1
        flag = 1;
    }
}

public class JiaoTi2 {
    public static void main(String[] args) throws Exception{
        int num = 10;
        PrintThread1 p1 = new PrintThread1();
        new Thread(()->{
            for(int i = 0;i<num;i++){
                p1.onePrint();
            }
        }).start();
        new Thread(()->{
            for(int i = 0;i<num;i++){
                p1.twoPrint();
            }
        }).start();
    }
}

