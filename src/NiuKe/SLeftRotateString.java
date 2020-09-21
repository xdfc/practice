package NiuKe;

/**
 * 2020.4.19
 * 左旋转字符串
 * 思路：利用字符串的substring()方法，分割成两部分相加
 */
public class SLeftRotateString {
    public String LeftRotateString(String str,int n) {
        String result = "";
        if(str.isEmpty()||str.length()==0)
            return result;
        result = str.substring(n) + str.substring(0,n);
        return result;
    }
}
