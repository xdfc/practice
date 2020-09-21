package LeetCode;

/**
 * 28.实现strStr()
 * 实现java中的indexOf方法
 */
public class Exercise28 {
    public static int strStr(String haystack, String needle) {
        int index = 0;
        if(haystack.length()<needle.length()){
            return -1;
        }
        if(needle.length()==0||haystack.length()==0){
            return 0;
        }
        char[] char1 = haystack.toCharArray();
        char[] char2 = needle.toCharArray();
        for(int i = 0;i<char1.length;i++){
            if(char1[i]!=char2[0]){
                if(i==char1.length-1)
                    return -1;
            }else {
                int j = 0;
                while((i+j<char1.length)&&(char1[i+j]==char2[j])){
                    if(j==char2.length-1)
                        return i;
                    j++;
                }
            }
            if(i==char1.length-1){
                index = -1;
            }
        }
        return index;
    }

    public static void main(String[] args) {
        System.out.println();
        System.out.println(strStr("mississippi","issipi"));
    }
}
