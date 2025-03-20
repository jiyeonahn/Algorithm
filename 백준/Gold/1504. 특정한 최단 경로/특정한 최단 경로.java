import java.util.*;
import java.io.*;
class Main{
    static int N;
    static ArrayList<Node>[] graph;
    static int INF = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N+1];
        for(int i = 0; i <= N; i++){
            graph[i] = new ArrayList<>();
        }

        for(int i = 0; i < E; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            graph[a].add(new Node(b,c));
            graph[b].add(new Node(a,c));
        }

        st = new StringTokenizer(br.readLine());
        int v1 = Integer.parseInt(st.nextToken());
        int v2 = Integer.parseInt(st.nextToken());

        int[] dist_1 = dijkstra(1);
        int[] dist_v1 = dijkstra(v1);
        int[] dist_v2 = dijkstra(v2);

        long route1 = (long) dist_1[v1] + dist_v1[v2] + dist_v2[N];
        long route2 = (long) dist_1[v2] + dist_v2[v1] + dist_v1[N];

        long answer = Math.min(route1, route2);

        System.out.println(answer >= INF ? -1 : answer);

    }
    public static int[] dijkstra(int start){
        PriorityQueue<Node> pq = new PriorityQueue<>((a,b)->a.d);
        int[] dist = new int[N+1];
        Arrays.fill(dist, INF);
        dist[start] = 0;
        pq.add(new Node(start, 0));

        while(!pq.isEmpty()){
            Node current = pq.poll();
            int now = current.x;
            int cost = current.d;

            if(cost > dist[now]) continue;

            for(Node next : graph[now]){
                int newCost = cost + next.d;
                if(newCost < dist[next.x]){
                    dist[next.x] = newCost;
                    pq.add(new Node(next.x, newCost));
                }
            }
        }
        return dist;
    }
}
class Node{
    int x;
    int d;
    public Node(int x, int d){
        this.x = x;
        this.d = d;
    }
}