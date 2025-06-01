import java.util.*;
import java.io.*;
class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][N];

        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b-a);

        StringTokenizer st;
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                pq.add(Integer.parseInt(st.nextToken()));
            }
        }

        int n = 0;
        int num = 0;
        while(!pq.isEmpty()){
            n++;
            num = pq.poll();
            
            if(n == N){
                break;
            }
        }

        System.out.println(num);
    }
}