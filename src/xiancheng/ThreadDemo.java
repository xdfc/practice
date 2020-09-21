package xiancheng;

class TicketThread implements Runnable{
    private int ticket = 10;
    public synchronized boolean sale(){
        if (this.ticket > 0) {
            try{
                Thread.sleep(100);
            }catch(InterruptedException e){
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "卖票,ticket =" + this.ticket--);
            return true;
        } else {
            System.out.println("票已售完");
            return false;
        }
    }
    public void run(){
        while(this.sale()){

        }
    }
}



public class ThreadDemo{
    public static void main(String[] args){
        TicketThread t1 = new TicketThread();
        TicketThread t2 = new TicketThread();
        TicketThread t3 = new TicketThread();
        new Thread(t1,"票贩子A").start();
        new Thread(t2,"票贩子B").start();
        new Thread(t3,"票贩子C").start();
    }
}


