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
    public static int n;
    public static char[][] matrix;
    public static boolean[][] flag;
    public static int[] dx = {-1, 1, 0, 0};
    public static int[] dy = {0, 0, -1, 1};
    public static int normal = 0;
    public static int blind = 0;
    public static Queue<Pos> qu = new LinkedList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        matrix = new char[n][n];
        flag = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            char[] input = br.readLine().toCharArray();
            for (int j = 0; j < n; j++) {
                matrix[i][j] = input[j];
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(!flag[i][j]) {
                    bfs(new Pos(i,j));
                    normal++;
                }
            }
        }

        flag = new boolean[n][n];

        // 적록 색맹을 위해 바꾸어준다.
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(matrix[i][j] == 'R'){
                    matrix[i][j] = 'G';
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(!flag[i][j]){
                    bfs(new Pos(i,j));
                    blind++;
                }
            }
        }

        System.out.println(normal);
        System.out.println(blind);
    }

    static void bfs(Pos d) {
        char color = matrix[d.x][d.y];
        flag[d.x][d.y] = true;
        qu.add(d);


        while(!qu.isEmpty()) {
            Pos t = qu.remove();
            int x1 = t.x;
            int y1 = t.y;

            for(int i=0; i<4; i++) {
                int x2 = x1 + dx[i];
                int y2 = y1 + dy[i];

                if(x2>=0 && x2<n && y2>=0 && y2<n &&
                        matrix[x2][y2] == color && !flag[x2][y2]) {
                    qu.add(new Pos(x2,y2));
                    flag[x2][y2] = true;
                }

            }
        }
    }
}
