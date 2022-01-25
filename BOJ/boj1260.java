import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.Queue;

public class boj1260 {//DFS와 BFS
    private static int N, M;
    private static boolean[] visited;
    private static StringBuilder sb = new StringBuilder();
    private static ArrayList<Integer>[] graph;
    private static Queue<Integer> queue = new LinkedList<>();

    public static void dfs(int idx) {
        visited[idx] = true;
        sb.append(idx).append(" ");
        for (int j = 0; j < graph[idx].size(); j++) {
            if(!visited[graph[idx].get(j)]) {
                dfs(graph[idx].get(j));
            }
        }
    }

    public static void bfs(int idx) {
        queue.offer(idx);
        visited[idx] = true;

        while (!queue.isEmpty()) {
            int n = queue.poll();
            sb.append(n).append(" ");
            for (int i = 0; i < graph[n].size(); i++) {
                if (!visited[graph[n].get(i)]) {
                    queue.offer(graph[n].get(i));
                    visited[graph[n].get(i)] = true;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());

        visited = new boolean[N + 1];
        graph = new ArrayList[N + 1];

        for (int i = 0; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph[a].add(b);
            graph[b].add(a);
        }

        for (int i = 0; i <= N; i++) {
            Collections.sort(graph[i]);
        }

        //dfs
        dfs(V);

        sb.append("\n");
        Arrays.fill(visited, false);

        //bfs
        bfs(V);

        System.out.println(sb.toString());
    }
}