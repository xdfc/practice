package NiuKe;

public class SAdd {
    public int Add(int num1,int num2) {
        char[] c1 = new char[num1];
        char[] c2 = new char[num2];
        String s1 = c1.toString();
        String s2 = c2.toString();
        String s = s1.concat(s2);
        return s.length();
    }
}
