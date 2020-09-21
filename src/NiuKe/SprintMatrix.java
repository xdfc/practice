package NiuKe;

import java.util.ArrayList;

/**
 * 2020.4.18
 * 顺时针打印矩阵
 * 本来自己写的思路不是很对，但是可以运行出来一些结果，缺少一些判断
 * 4.19
 * 每次都判断是否全部打印结束，就可以通过所有测试样例
 * 但是代码不是很简洁，
 *
 */


public class SprintMatrix {
    public ArrayList<Integer> printMatrix(int [][] matrix) {
        /*
        //可以成功运行，思路和我的类似，作为参考
        ArrayList<Integer> arr = new ArrayList<Integer>();
        int up = 0;
        int left = 0;
        int down = matrix.length - 1;
        int right = matrix[0].length - 1;

        while(left<=right && up<=down){

            for(int i = left ; i <= right ; i++)
                arr.add(matrix[up][i]);
            up++;
            for(int i = up ; i <= down ; i++)
                arr.add(matrix[i][right]);
            right--;
            if(up-1 != down){
                for(int i = right ; i >= left ; i--)
                    arr.add(matrix[down][i]);
            }
            down--;
            if(left != right+1){
                for(int i = down ; i >= up ; i--)
                    arr.add(matrix[i][left]);
            }
            left++;
        }
        return arr;

         */


        //自己写的
        //按照逆时针顺序打印
        ArrayList<Integer> arrayList = new ArrayList<>();
        if(matrix.length==1&&matrix[0].length==1){
            arrayList.add(matrix[0][0]);
            return arrayList;
        }
        int number = matrix.length*matrix[0].length; //一共多少元素
        int quan = 0;
        while(number!=0){
            int i = quan;
            int j = quan;
            int k = matrix[0].length-quan-1;
            int l = matrix.length-quan-1;
            System.out.println("圈数："+quan);
            if(matrix.length%2!=0&&matrix[0].length%2!=0){ //最后只剩中间一个的时候
                if(k==matrix[0].length/2&&l==matrix.length/2){
                    System.out.println(matrix[k][l]);
                    arrayList.add(matrix[k][l]);
                    number--;
                    if(number==0)  //每次判断是否打印结束了
                        break;
                }
            }
            for( ;j<matrix[0].length - quan-1;j++){ //向右打印
                System.out.println("i是："+i+",j是："+j+"数组是："+matrix[i][j]);
                arrayList.add(matrix[i][j]);
                number--;
                if(number==0)
                    break;
            }
            System.out.println("******");
            for( ;i<matrix.length - quan - 1;i++){  //向下打印
                System.out.println("i是："+i+",j是："+j+"数组是："+matrix[i][j]);
                arrayList.add(matrix[i][j]);
                number--;
                if(number==0)
                    break;
            }
            System.out.println("******");
            for( ;k > quan;k--){   //向左打印
                System.out.println("l是："+l+",k是："+k+"数组是："+matrix[l][k]);
                arrayList.add(matrix[l][k]);
                number--;
                if(number==0)
                    break;
            }
            System.out.println("******");
            for( ;l > quan;l--){  //向上打印
                System.out.println("l是："+l+",k是："+k+"数组是："+matrix[l][k]);
                arrayList.add(matrix[l][k]);
                number--;
                if(number==0)
                    break;
            }
            System.out.println("******");
            System.out.println("number是："+number);
            quan++;
        }
        return arrayList;
    }
}
