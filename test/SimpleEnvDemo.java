public class SimpleEnvDemo {
    public static void main(String[] args) {
        // 读取环境变量 MY_STRING
        String myString = System.getenv("MY_STRING");
        
        if (myString == null || myString.isEmpty()) {
            System.out.println("未设置环境变量 MY_STRING，使用默认值 'Hello'");
            myString = "Hello";
        }
        
        // 计算字符串长度
        int length = myString.length();
        
        System.out.println("环境变量 MY_STRING 的值为: " + myString);
        System.out.println("字符串长度为: " + length);
    }
}
