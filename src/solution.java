import java.util.*;

public class solution {

    public static int[][] matrix;
    public static Queue<Integer> qu = new LinkedList<>();
    public static boolean[] flag;
    public static int N,M;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        matrix = new int[N+1][N+1];

        for (int i=0; i<M; i++) {
            int vertex1 = sc.nextInt();
            int vertex2 = sc.nextInt();
            matrix[vertex1][vertex2] = 1;
        }

        flag = new boolean[N+1];

        bfs(1);
    }

    public static void bfs(int start) {
        qu.offer(start);
        flag[start] = true;
        int result = 0;

        while(!qu.isEmpty()) {
            start = qu.poll();

            for (int i = 0; i < flag.length; i++) {
                if(!flag[i] && matrix[start][i] ==1){
                    qu.offer(i);
                    flag[i] = true;
                    result++;
                }
            }
        }

        System.out.println(result);
    }
}
