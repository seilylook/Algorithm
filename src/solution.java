import java.util.*;

class Pos{
    int x;
    int y;

    public Pos(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class solution {
    static int[][] matrix;
    static int width, height, K;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static Queue<Pos> qu;
    static boolean[] flag;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        height = sc.nextInt();
        width = sc.nextInt();
        K = sc.nextInt();

        matrix = new int[height][width];

        for (int i = 0; i < K; i++) {
            int y1 = sc.nextInt();
            int x1 = sc.nextInt();
            int y2 = sc.nextInt();
            int x2 = sc.nextInt();

            for (int j = x1; j<x2; j++) {
                for (int k = y1; k < y2; k++) {
                    matrix[j][k] = 1;
                }
            }
        }

        flag = new boolean[width];
        int area = 0;
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if(matrix[i][j] != 1) {
                    list.add(bfs(i,j));
                    area++;
                }
            }
        }
        Collections.sort(list);
        System.out.println(area);

    }

    private static int bfs(int a, int b) {
        qu = new LinkedList<>();
        qu.add(new Pos(a,b));
        int sum =0;
        matrix[a][b] = 1;

        while(!qu.isEmpty()) {
            Pos p = qu.poll();
            int temp_x = p.x;
            int temp_y = p.y;

            for (int i = 0; i < 4; i++) {
                int xdir = temp_x + dx[i];
                int ydir = temp_y + dy[i];

                if(temp_x < 0 || temp_x >= height || temp_y <0 || temp_y>= width && matrix[xdir][ydir] != 1) {
                    qu.add(new Pos(xdir,ydir));
                    matrix[xdir][ydir] = 1;
                    sum++;
                }
            }
        }
        return sum+1;
    }
}
