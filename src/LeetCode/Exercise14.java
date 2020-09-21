package LeetCode;
public class Exercise14 {
    public static String longestCommonPrefix(String[] strs) {
        if(strs.length==1){
            return strs[0];
        }
        char[][] chars = new char[strs.length][];
        int l = 0,i;
        String str = "";
        for(int k = 0;k<strs.length;k++){
            chars[k] = strs[k].toCharArray();
        }
        for(i = 0;i<strs.length-1;i++){
            int j = 0;
            while((j<chars[i].length-1)&&(j<chars[i+1].length-1)&&(chars[i][j]==chars[i+1][j])){
                j++;
            }
            if(i == 0){
                l = j;
            }
            l = l<=j?l:j;
        }

        if(l==0){
        }else{
            str = strs[0].substring(0,l);
        }
        return str;
    }
    public static void main(String[] args) {
        String[] str = {"a","a"};
        System.out.println(longestCommonPrefix(str));
    }

}
