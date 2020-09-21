package Demo;

public class Test {
    private static Object object1 = new Object();
    private static Object object2 = new Object();

    public static void main(String[] args) {
        new Thread(()->{
            synchronized(object1){
                sleep(100);
                System.out.println("222");
                synchronized (object2){
                    System.out.println("等待2");
                }
            }
        }).start();
        new Thread(()->{
            synchronized (object2){
                sleep(100);
                System.out.println("111");
                synchronized(object1){
                    System.out.println("等待1");
                }
            }
        }).start();
    }

    public static void sleep(int time){
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
