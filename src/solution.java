import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class solution {
    static int N,M;
    static int[][] matrix;
    static boolean[] flag;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        matrix = new int[N+1][N+1];

        for (int i = 0; i < M; i++) {
            int vertex1 = Integer.parseInt(br.readLine());
            int vertex2 = Integer.parseInt(br.readLine());

            matrix[vertex1][vertex2] = 1;
        }

        flag = new boolean[N+1];
        int result = 0;

        for (int i = 1; i <= N; i++) {
            if(!flag[i]){
                dfs(i);
                result++;
            }
        }
        System.out.println(result);
    }

    public static void dfs(int start){
        if(flag[start] == true){
            return;
        }
        else{
            flag[start] = true;
            for (int i=1; i<=N; i++){
                if(matrix[start][i] == 1){
                    dfs(i);
                }
            }
        }
    }
}
