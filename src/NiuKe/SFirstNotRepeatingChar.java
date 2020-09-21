package NiuKe;



/**
 * 2020.4.18
 * 第一个只出现一次的字符
 * 思路：双层循环遍历，每次查找是否有相同的，
 * 如果有，跳出循环，如果没有，且字符串已全部遍历，则返回索引
 * 思路2：用另外一个数组保存，ASCII码作为索引，出现次数作为值
 * 按照相同顺序遍历第一次出现1的时候
 */

public class SFirstNotRepeatingChar {
    public int FirstNotRepeatingChar(String str) {
        /*
        char[] chars = str.toCharArray();
        for(int i = 0;i<chars.length;i++){
            for(int j = 0;j<chars.length;j++){
                if(i!=j&&chars[i]==chars[j]) //i和j不相等，但是字符一样
                    break;  //结束判断
                if(j==chars.length-1)  //全部遍历结束
                    return i;  //返回索引
            }
        }
        return -1;

         */
        int[] chars = new int[58];
        //遍历字符串，以字符ASCII码为索引，出现一次+1，当做数组值
        for(int i = 0;i<str.length();i++){
            chars[(int)str.charAt(i)-'A'] += 1;
        }
        //按照相同顺序，遍历数组，第一次出现1的时候对应的字符串位置就是第一个
        for(int i=0;i<str.length();i++){
            if(chars[((int)str.charAt(i))-'A']==1)
                return i;
        }
        return -1;

    }
}
