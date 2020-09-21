package Demo;

/**
 * 自定义一个异常类
 */
public class DefineException {
    public static void main(String[] args) throws Exception{
        Connect.connect(7);
    }
}

class ConnectException extends RuntimeException{
    private String name;
    public ConnectException(String name){
        super(name);
    }
}

class Connect{
    public static void connect(int num)throws ConnectException {
        if(num>10){
            throw new ConnectException("连接数目超过10");
        }else{
            System.out.println("能正常连接");
        }
    }
}

