import java.util.*;

class solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Queue<Integer> qu = new LinkedList<>();
        Queue<Integer> result = new LinkedList<>();

        for (int i=0; i<n; i++){
            qu.add(i+1);
        }
        int temp=0;

        while(qu.size() != 1){
            result.add(qu.poll());
            if(qu.size()==1){
                result.add(qu.poll());
                break;
            }
            temp= qu.poll();
            qu.add(temp);
        }
        System.out.println(result);
    }
}

