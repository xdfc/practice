import java.util.Scanner;

/**
 * 第一行输入n和m
 * 后面获取n*m的二维数组
 * 然后输入i和j
 * 输出i行j列的二维数组元素
 */
public class ScannerDemo4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
            int line = scanner.nextInt();
            int col = scanner.nextInt();
            int[][] mat = new int[line][col];
            for (int i = 0; i < mat.length; i++) {
                for (int j = 0; j < mat[0].length; j++) {
                    mat[i][j] = scanner.nextInt();
                }
            }
            int i = scanner.nextInt();
            int j = scanner.nextInt();
            System.out.println(mat[i-1][j-1]);
    }
}
