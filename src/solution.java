import java.util.*;

public class solution {

    public static int N;
    public static int M;
    public static int[][] matrix;
    public static boolean[] flag;

    public static void dfs(int start){
        if(flag[start] == true){
            return;
        }
        else{
            flag[start] = true;
            for (int i=1; i<=N; i++){
                if(matrix[start][i] == 1) {
                    dfs(i);
                }
            }
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // N은 정점, M은 간선의 갯수
        N = sc.nextInt();
        M = sc.nextInt();

        matrix = new int[N+1][N+1];

        for (int i=0; i<M; i++) {
            int vertex1 = sc.nextInt();
            int vertex2 = sc.nextInt();
            matrix[vertex1][vertex2] = 1;
        }

        int result = 0;
        flag = new boolean[N+1];

        for (int i=1; i<=N; i++) {
            if(flag[i] == false) {
                dfs(i);
                result++;
            }
        }

        System.out.println(result);
    }
}
//6
//5
//1
//2
//2
//5
//5
//1
//3
//4
//4
//6
