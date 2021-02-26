import java.awt.image.ImageProducer;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class solution {
    static int N,M;
    static int[][] matrix;
    static int r,c,d;
    // r은 북쪽 기준
    // c는 서쪽 기준
    // d는 바라보는 방향, 0은 북, 1은 동, 2는 남, 3은 서
    static int xBot, yBot, dirBot, dirRotate;
    static int[][] offs = {
            {0,1},
            {1,0},
            {0,1},
            {-1,0}
    };

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] temp = br.readLine().split(" ");
        N = Integer.parseInt(temp[0]);
        M = Integer.parseInt(temp[1]);

        temp = br.readLine().split(" ");
        yBot = Integer.parseInt(temp[0]);
        xBot = Integer.parseInt(temp[1]);
        dirBot = Integer.parseInt(temp[2]);
        matrix = new int[N][M];

        for (int i = 0; i < N; i++) {
            temp = br.readLine().split(" ");
            for (int j = 0; j < temp.length; j++) {
                matrix[i][j] = Integer.parseInt(temp[j]);
            }
        }
        robot_cleaner(xBot, yBot, 0);

        int result =0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(matrix[i][j] != 1) {
                    result++;
                }
            }
        }

        System.out.println(result);
    }

    public static void robot_cleaner(int x, int y, int cnt) {
        if(cnt == 4) {
            int backY = y + offs[dirRotate][1] * -1;
            int backX = x + offs[dirRotate][0] * -1;
            if(matrix[backY][backX] != 1) {
                robot_cleaner(backX, backY, 0);
            }
            else{
                return;
            }
        }
        else{
            // 2.a 현재 위치를 청소한다.
            if(matrix[x][y] == 0 ){
                matrix[x][y] = 2;
            }

            // 2.b 왼쪽을 탐색한다.
            dirRotate = dirBot == 0? 3 : dirBot-1;

            int newY = y+offs[dirRotate][1], newX = x+offs[dirRotate][0];

            // 2.c 네 방향 모두가 청소되었거나 벽인 경우, 바라보는 방향을 유지한 채 한 칸 후진을 하고 2번으로 돌아간다.
            if(matrix[newY][newX] == 0) {
                dirBot = dirRotate;
                robot_cleaner(newX, newY, 0);
            }

            // 2.d 네 방향 모두 청소가 되었거나 벽이면서, 뒤쪽 방향이 벽이라 후진도 할 수 없는 경우에는 작동을 멈춘다.
            else{
                dirBot = dirRotate;
                robot_cleaner(x,y, cnt+1);
            }
        }
    }
}
