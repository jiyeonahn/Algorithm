import java.util.*;
import java.io.*;

class Main {
    static ArrayList<Node>[] graph;
    static int N;
    static int X;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); //N명의 학생
        int M = Integer.parseInt(st.nextToken()); //M개의 단방향 도로
        X = Integer.parseInt(st.nextToken()); //파티장소

        graph = new ArrayList[N + 1];
        for (int i = 0; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int time = Integer.parseInt(st.nextToken());
            graph[start].add(new Node(end, time));
        }

        int max = 0;
        for (int i = 1; i <= N; i++) {
            max = Math.max(max, dijkstra(i, X) + dijkstra(X, i));
        }
        System.out.println(max);
    }

    public static int dijkstra(int start, int end) {
        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.time));

        int[] dist = new int[N + 1];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[start] = 0;
        pq.add(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node now = pq.poll();

            if(now.time > dist[now.node]) continue;

            for (Node next : graph[now.node]) {
                if (dist[now.node] + next.time < dist[next.node]) {
                    dist[next.node]  = dist[now.node] + next.time;
                    pq.add(new Node(next.node,dist[now.node] + next.time));
                }

            }
        }
        return dist[end];
    }
}

class Node {
    int node;
    int time;

    public Node(int node, int time) {
        this.node = node;
        this.time = time;
    }
}