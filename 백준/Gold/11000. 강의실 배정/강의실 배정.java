import java.util.*;
import java.io.*;
class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> {
            if(a[0] == b[0]){
                return a[1] - b[1];
            }
            return a[0] - b[0];
        });

        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int S = Integer.parseInt(st.nextToken());
            int T = Integer.parseInt(st.nextToken());

            pq.add(new int[]{S,T});
        }

        PriorityQueue<Integer> end = new PriorityQueue<>();
        end.add(0);
        while(!pq.isEmpty()){
            int[] cur = pq.poll();
            if(end.peek() <= cur[0]){
                end.poll();
            }
            end.add(cur[1]);
        }

        System.out.println(end.size());
    }
}

