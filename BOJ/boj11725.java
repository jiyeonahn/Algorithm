import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class boj11725 {
    private static ArrayList<Integer>[] graph;
    private static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;

        parent = new int[N+1];

        graph = new ArrayList[N+1];
        for(int i = 0; i <= N; i++){
            graph[i] = new ArrayList<>();
        }

        for(int i = 0; i < N-1; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph[a].add(b);
            graph[b].add(a);
        }

        dfs(1,0);

        for(int i = 2; i <= N; i++){
            System.out.println(parent[i]);
        }
    }

    public static void dfs(int node, int pNode){
        if (parent[node] != 0) return;
        parent[node] = pNode;

        for(int n : graph[node]){
            dfs(n, node);
        }
    }
}