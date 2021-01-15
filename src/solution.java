import java.util.*;
import java.io.*;

public class solution {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = br.read();

        for (int tc=0; tc<N; tc++) {
            String s = br.readLine();
            String[] temp = new String[s.length()];

            for (int i=0; i<temp.length; i++) {
                temp = s.split("");
            }
            for (int i=temp.length-1; i>=0; i--) {
                System.out.printf("%s ", temp[i]);
            }
        }

    }
}

