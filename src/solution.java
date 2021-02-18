import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Pos{
    int x;
    int y;

    public Pos(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class solution {
    static int line;
    static int[][] matrix;
    static boolean[][] visited;
    static boolean[] flag;
    static Queue<Pos> qu;
    static int[] dx = {-2,-1,2,1,2,1,-2,-1};
    static int[] dy = {1,2,1,2,-1,-2,-1,-2};
    static int test;
    static int start_x, start_y, end_x, end_y;
    static int count = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        test = Integer.parseInt(br.readLine());

        for (int i=0; i<test; i++){
            line = Integer.parseInt(br.readLine());
            matrix = new int[line][line];
            visited = new boolean[line][line];

            qu = new LinkedList<Pos>();

            StringTokenizer st = new StringTokenizer(br.readLine());
            start_x = Integer.parseInt(st.nextToken());
            start_y = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            end_x = Integer.parseInt(st.nextToken());
            end_y = Integer.parseInt(st.nextToken());

            bfs(new Pos(start_x, start_y));
            System.out.println(matrix[end_x][end_y]);
        }


    }

    public static void bfs(Pos p){
        if(p.x == end_x && p.y == end_y) {
            return;
        }
        visited[p.x][p.y] = true;

        qu.add(p);

        while(!qu.isEmpty()) {
            Pos dir = qu.remove();
            int x1 = dir.x;
            int y1 = dir.y;

            for (int i=0; i<dx.length; i++){
                int x2 = x1 + dx[i];
                int y2 = y1 + dy[i];

                if(x2 >= 0 && x2<line && y2>=0 && y2<line && !visited[x2][y2]){
                    qu.add(new Pos(x2, y2));
                    visited[x2][y2] = true;
                    matrix[x2][y2] = matrix[x1][y1] + 1;
                    count++;
                }
            }
        }
    }
}
