import java.util.*;
import java.io.*;

public class solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int K = sc.nextInt();

        double[][] Matrix = new double[N+1][N+1];
        int index;

        for (int i=0; i<N; i++) {
            for (int j=0; j<N; j++) {
                index = sc.nextInt();
                Matrix[i][index] = sc.nextDouble();
            }
        }

        double[] max= new double[N];


        for (int i=0; i<N; i++) {
            max[i] = Math.max(Math.max(Matrix[i][1], Matrix[i][2]), Math.max(Matrix[i][3], Matrix[i][4]));
        }
        Arrays.sort(max);

        double result = max[1]+max[2]+max[3];

        System.out.printf("%f", result);

    }
}

