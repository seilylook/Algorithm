import java.util.*;
import java.io.*;

public class solution {
    static int[] flag;
    static int answer =0;
    static Queue<Integer> qu = new LinkedList<>();
    static int [][] matrix;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int tc = sc.nextInt();
        matrix = new int[n+1][n+1];
        flag = new int[n+1];

        for (int i=0; i<tc; i++) {
            int vertex1 = sc.nextInt();
            int vertex2 = sc.nextInt();
            matrix[vertex1][vertex2] = 1;
        }
        bfs(1);
        System.out.print(answer);
    }

    private static void bfs(int start) {
        qu.offer(start);
        flag[start] = 1;

        while (!qu.isEmpty()) {
            start = (int) qu.poll();
            for (int i = 1; i < flag.length; i++) {

                if (flag[i] != 1 && matrix[start][i] == 1) {
                    qu.offer(i);
                    flag[i] = 1;
                    answer++;

                }
            }
        }
    }
}