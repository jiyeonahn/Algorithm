import java.util.*;
import java.io.*;

class Main {
    static int INF = Integer.MAX_VALUE;
    static ArrayList<Node>[] graph;
    static int[] dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        int K = Integer.parseInt(br.readLine()) - 1;

        graph = new ArrayList[V];
        for (int i = 0; i < V; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken()) - 1;
            int v = Integer.parseInt(st.nextToken()) - 1;
            int w = Integer.parseInt(st.nextToken());

            graph[u].add(new Node(v, w));
        }

        dist = new int[V];
        Arrays.fill(dist, INF);
        dist[K] = 0;

        dijkstra(K);

        for (int i = 0; i < V; i++) {
            System.out.println(dist[i] == INF ? "INF" : dist[i]);
        }
    }

    public static void dijkstra(int k) {
        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> a.w - b.w);
        pq.add(new Node(k, 0));

        while (!pq.isEmpty()) {
            Node node = pq.poll();
            int now = node.v;

            for (Node next : graph[now]) {
                int newCost = dist[now] + next.w;
                if (dist[next.v] > newCost) {
                    dist[next.v] = newCost;
                    pq.add(new Node(next.v, newCost));
                }
            }
        }
    }
}

class Node {
    int v;
    int w;

    public Node(int v, int w) {
        this.v = v;
        this.w = w;
    }
}