package xiancheng;

/**
 * 生产者消费者模型
 * 通过synchronized同步
 * 通过wait()和notify()解决重复生产消费问题
 */
public class Produce_Com {
    public static void main(String[] args){
        Message message = new Message();
        new Thread(new Producer(message)).start();//启动生产者
        new Thread(new Consumer(message)).start();//启动消费者
    }
}
class Producer implements Runnable{   //生产者生产数据
    private Message msg;
    public Producer(Message msg){
        this.msg  =msg;
    }
    @Override
    public void run() {
        for(int i = 0;i<100;i++){
            if(i%2==0){
                this.msg.set("java","hello java");
            }else{
                this.msg.set("world","hello world");
            }
        }
    }
}
class Consumer implements Runnable{   //消费者取走数据
    private Message msg;
    public Consumer(Message msg) {
        this.msg = msg;
    }
    @Override
    public void run() {
        for(int i = 0;i<100;i++){
            System.out.println(this.msg.get());
        }
    }
}
class Message{
    private String title;
    private String content;
    private boolean flag; //表示消费或者生产
    //flag = true：允许生产，不允许消费；
    //flag = false：允许消费，不允许生产
    public synchronized void set(String title,String content){
        if(this.flag == false){ //不允许生产，只允许消费
            try {
                super.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.title = title;
        this.content = content;
        this.flag = false; //已经生产过了
        super.notify(); //唤醒等待的线程
    }
    public synchronized String get(){
        if(this.flag == true){ //不允许消费，只允许生产
            try {
                super.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try{
            return this.title+" - "+this.content;
        }finally {
            this.flag = true;
            super.notify();
        }
    }
}

