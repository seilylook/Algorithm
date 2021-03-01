import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class solution {
    static int N;
    static int[] numbers;
    static int[] operators;
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        numbers = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        operators = new int[4];

        st = new StringTokenizer(br.readLine(), " ");

        for (int i = 0; i < 4; i++) {
            operators[i] = Integer.parseInt(st.nextToken());
        }

        calculate(numbers[0], 1);

        System.out.println(max);
        System.out.println(min);

    }

    public static void calculate(int num, int index){

        if(index == N){
            max = Math.max(max,num);
            min = Math.min(min,num);
        }


        for (int i = 0; i < 4; i++) {
            if(operators[i] > 0 ){
                operators[i]--;

                switch (i) {
                    case 0:
                        calculate(num + numbers[index], index+1);
                        break;

                    case 1:
                        calculate(num - numbers[index], index+1);
                        break;

                    case 2:
                        calculate(num * numbers[index], index+1);
                        break;

                    case 3:
                        calculate(num / numbers[index], index+1);
                        break;
                }

                operators[i] ++;
            }
        }
    }
}
