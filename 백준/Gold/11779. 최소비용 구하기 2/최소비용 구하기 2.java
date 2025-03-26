import java.util.*;
import java.io.*;
class Main{
    static ArrayList<Node>[] graph;
    static int[] dist;
    static int[] path;
    static int INF = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); //도시의 개수
        int m = Integer.parseInt(br.readLine()); //버스의 개수

        dist = new int[n+1];
        path = new int[n+1];
        Arrays.fill(dist, INF);
        Arrays.fill(path, -1);

        graph = new ArrayList[n+1];
        for(int i = 0; i <= n; i++){
            graph[i] = new ArrayList<>();
        }

        StringTokenizer st;

        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            graph[start].add(new Node(end, cost));
        }

        st = new StringTokenizer(br.readLine());
        int u = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());

        dist[u] = 0;
        dijkstra(u);

        System.out.println(dist[v]);

        StringBuilder sb = new StringBuilder();
        int now = v;
        ArrayList<Integer> list = new ArrayList<>();
        while(true){
            list.add(now);
            if(now == u) break;
            now = path[now];
        }

        Collections.reverse(list);
        for(int l : list){
            sb.append(l).append(" ");
        }
        System.out.println(list.size());
        System.out.println(sb);
    }
    public static void dijkstra(int start){
        PriorityQueue<Node> pq = new PriorityQueue<>((a,b)->a.cost);
        pq.add(new Node(start, 0));

        while(!pq.isEmpty()){
            Node node = pq.poll();
            int now = node.end;
            int cost = node.cost;

            if(cost > dist[now]) continue;

            for(Node next : graph[now]){
                int newCost = dist[now] + next.cost;
                if(newCost < dist[next.end]){
                    dist[next.end] = newCost;
                    path[next.end] = now;
                    pq.add(new Node(next.end, newCost));
                }
            }
        }
    }
}
class Node{
    int end;
    int cost;
    public Node(int end, int cost){
        this.end = end;
        this.cost = cost;
    }
}