import java.util.*;
import java.io.*;

public class solution {
    public static void main(String[] args) throws IOException{
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        char[][] map = new char[101][101];

        for (int i = 0; i < n; i++) {
            String[] s = sc.next().split("");
            for (int j = 0; j < n; j++) {
                map[i][j] = s[j].charAt(0);
            }
            // 벽 또한 짐으로 판단
            map[i][n] = 'X';
            map[n][i] = 'X';
        }

        // (X or 벽) 판단
        int r = 0;
        int c = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - 1; j++) {
                r += (map[i][j] == '.' && map[i][j + 1] == '.' && map[i][j + 2] == 'X') ? 1 : 0;
                c += (map[j][i] == '.' && map[j + 1][i] == '.' && map[j + 2][i] == 'X') ? 1 : 0;
            }
        }

        System.out.println(r + " " + c);


    }
}