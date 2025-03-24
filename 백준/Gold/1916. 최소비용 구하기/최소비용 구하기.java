import java.util.*;
import java.io.*;
class Main{
    static int INF = Integer.MAX_VALUE;
    static int[] dist;
    static int N;
    static ArrayList<Node>[] bus;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine()); //도시의 개수
        int M = Integer.parseInt(br.readLine()); //버스의 개수

        dist = new int[N+1];
        Arrays.fill(dist, INF);

        bus = new ArrayList[N+1];
        for(int i = 0; i <= N; i++){
            bus[i] = new ArrayList<>();
        }

        StringTokenizer st;
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            bus[u].add(new Node(v, cost));
        }

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        dist[start] = 0;
        dijkstra(start);

        System.out.println(dist[end]);
    }

    public static void dijkstra(int n){
        PriorityQueue<Node> pq = new PriorityQueue<>((a,b) -> a.cost);
        pq.add(new Node(n,0));
        boolean[] visited = new boolean[N+1];

        while(!pq.isEmpty()){
            Node current = pq.poll();
            int now = current.v;
            int cost = current.cost;
            
            if(cost > dist[now]) continue;

            for(Node node : bus[now]){
                int newCost = dist[now] + node.cost;
                if(newCost < dist[node.v]){
                    dist[node.v] = newCost;
                    pq.add(new Node(node.v, newCost));
                }
            }
        }

    }
}
class Node{
    int v;
    int cost;
    public Node(int v, int cost){
        this.v = v;
        this.cost = cost;
    }
}