import java.util.*;
import java.io.*;
class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] time = new int[N][2];

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            time[i][0] = Integer.parseInt(st.nextToken());
            time[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(time, Comparator.comparingInt(a->a[0]));
        pq.add(time[0][1]);

        int room = 1;
        for(int i = 1; i < N; i++){
            if(time[i][0]<pq.peek()){//시작 시간이 끝나는 시간보다 작을 때
                //회의실을 같이 쓸 수 없음
                room++;
            }else{//시작 시간이 끝나는 시간보다 크거나 같을 때
                //회의실을 같이 쓸 수 있음
                pq.poll();
            }
            pq.add(time[i][1]);
        }

        System.out.println(room);
    }
}