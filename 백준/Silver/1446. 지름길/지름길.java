import java.util.*;
import java.io.*;
class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());
        ArrayList<Road>[] road = new ArrayList[D+1];
        int[] dist = new int[D+1];

        for (int i = 0; i <= D; i++) {
            road[i] = new ArrayList<>();
            if(i==D) continue;
            road[i].add(new Road(i+1,1));
        }

        PriorityQueue<Road> pq = new PriorityQueue<>((a,b) -> a.cost - b.cost);

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            if(end > D) continue;
            road[start].add(new Road(end, cost));
        }

        Arrays.fill(dist, Integer.MAX_VALUE);
        pq.offer(new Road(0,0));
        dist[0] = 0;

        while(!pq.isEmpty()){
            Road r = pq.poll();
            int end = r.end;
            int cost = r.cost;

            if(cost > dist[end]) continue;

            for(Road next : road[end]){
                int nextEnd = next.end;
                int nextCost = next.cost;
                int newCost = nextCost + dist[end];

                if(newCost < dist[nextEnd]){
                    dist[nextEnd] = newCost;
                    pq.offer(new Road(nextEnd, newCost));
                }
            }
        }

        System.out.println(dist[D]);
    }
}
class Road{
    int end;
    int cost;
    public Road(int end, int cost){
        this.end = end;
        this.cost = cost;
    }
}