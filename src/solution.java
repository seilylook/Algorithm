import java.util.*;
import java.io.*;

public class solution {
    static int n;
    static int[][] matrix;
    static int[] dx = {-1,0,0,1};
    static int[] dy = {0, 1, -1,0};
    static int cnt = 0;
    static int numbers=0;
    static ArrayList<Integer> list = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        matrix = new int[n][n];
        int answer =0;

        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                if(matrix[i][j] != 0) {
                    numbers =0;
                    dfs(i,j);
                    cnt++;
                    list.add(numbers);
                }
            }
        }
        System.out.printf("%d\n", cnt);

        for (int i=0; i<list.size(); i++) {
            System.out.printf("%d\n", list.get(i));
        }
    }
    private static int dfs(int x, int y) {

        for (int i=0; i<4; i++) {
            int nextx = x + dx[i];
            int nexty = y + dy[i];
            if(nextx < 0 || nexty < 0 || nextx >= n || nexty >= n) {
                continue;
            }
            if(matrix[nextx][nexty] == 0) {
                continue;
            }
            matrix[nextx][nexty] = 0;
            numbers++;
            dfs(nextx, nexty);
        }
        return numbers;
    }
}