import java.util.*;
import java.io.*;
class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        int answer = 0;
        int money = 0;
        while(K > 0){
            for(int a : arr){
                if(K < a){
                    break;
                }
                money = a;
            }
            answer += K/money;
            K = K%money;
        }
        System.out.println(answer);
    }
}