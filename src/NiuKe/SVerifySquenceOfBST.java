package NiuKe;

import java.util.Arrays;

/**
 * 2020.4.5
 * 二叉搜索树的后序遍历序列
 * 思路：根据性质，最后一个为根节点，然后分为两个数组
 * 左边的数组小于根节点，右边的数组大于根节点
 * 如果数组长度大于2，说明还有子树，需要进一步递归
 */

public class SVerifySquenceOfBST {
    public boolean VerifySquenceOfBST(int [] sequence) {
        if(sequence.length==0||sequence==null){
            return false;
        }
        int rootValue = sequence[sequence.length-1];
        int index = 0;
        boolean flagL = true;
        boolean flagR = true;
        while(sequence[index]<rootValue){
            index++;
        }
        //以根节点为界限，将数组分为左右两块
        //左边比根节点小，右边比根节点大
        int[] left = Arrays.copyOfRange(sequence,0,index);
        int[] right = Arrays.copyOfRange(sequence,index,sequence.length-1);
        for(int lefttmp:left){  //左边的数组小于根节点
            if(lefttmp>rootValue)
                return false;
        }
        for(int rtmp:right){   //右边的数组大于根节点
            if(rtmp<rootValue)
                return false;
        }
        //如果数组长度大于2，说明还有子树，需要进一步递归
        if(left.length>2){
            flagL = VerifySquenceOfBST(left);
        }
        if(right.length>2){
             flagR = VerifySquenceOfBST(right);
        }
        return flagL&&flagR;

    }
}
