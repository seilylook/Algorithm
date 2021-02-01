import java.util.*;

public class solution {
    public static int[][] matrix;
    public static boolean[] flag;
    public static int height;
    public static int weight;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        weight = sc.nextInt();
        height = sc.nextInt();
        matrix = new int[weight][height];

        for (int i = 0; i < weight; i++) {
            for (int j = 0; j < height; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }

        flag = new boolean[height];
        int result = 0;

        for (int i = 0; i < height; i++) {
            if(!flag[i]) {
                dfs(i);
                result++;
            }
        }

        System.out.println(result);
    }

    public static void dfs(int start) {
        if(flag[start] == true) {
            return;
        }
        else {
            flag[start] = true;
            for (int i = 0; i < height; i++) {
                if(matrix[start][i] == 1){
                    dfs(i);
                }
            }
        }
    }
}
