import java.util.*;
import java.io.*;
class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> plus = new PriorityQueue<>(Comparator.reverseOrder());
        PriorityQueue<Integer> minus = new PriorityQueue<>();

        for(int i = 0; i < N; i++){
            int num = Integer.parseInt(br.readLine());
            if(num > 0){
                plus.add(num);
            }else{
                minus.add(num);
            }
        }

        int sum = 0;
        while(!plus.isEmpty()){
            int a = plus.poll();
            if(plus.isEmpty()){
                sum += a;
                break;
            }
            int b = plus.poll();
            if(b==1) sum += a+b; //내림차순이므로 b=1이면 a도 1인 경우도 포함이므로 a=1일때는 조건 안 걸어도 됨
            else sum += a*b;
        }

        while(!minus.isEmpty()){
            int a = minus.poll();
            if(minus.isEmpty()){
                sum += a;
                break;
            }
            int b = minus.poll();
            sum += a*b;
        }
        System.out.println(sum);
    }
}