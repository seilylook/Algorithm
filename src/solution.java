import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class solution {

    static int N;
    static int[] time;
    static int[] pay;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        time = new int[N+10];
        pay = new int[N+10];
        String[] str;

        for (int i = 1; i <= N; i++) {
            str = br.readLine().split( " ");
            time[i] = Integer.parseInt(str[0]);
            pay[i] = Integer.parseInt(str[1]);
        }

        find();

    }

    public static void find(){

        int[] dp = new int[N+10];
        int max = 0;

        for (int i = 1; i <= N+1; i++) {
            dp[i] = Math.max(dp[i], max);
            dp[time[i]+i] = Math.max(dp[time[i]+i],pay[i]+dp[i]);
            max = Math.max(max, dp[i]);
        }
        System.out.println(max);
    }

}

