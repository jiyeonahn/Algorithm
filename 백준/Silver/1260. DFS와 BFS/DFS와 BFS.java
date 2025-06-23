import java.util.*;
import java.io.*;
class Main{
    static StringBuilder sb = new StringBuilder();
    static ArrayList<Integer>[] graph;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());
        
        graph = new ArrayList[N+1];
        
        for(int i = 0; i <= N; i++){
            graph[i] = new ArrayList<>();
        }
        
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            
            graph[a].add(b);
            graph[b].add(a);
        }
        
        for(ArrayList<Integer> g : graph){
            Collections.sort(g);
        }
        
        visited = new boolean[N+1];
        visited[V] = true;
        dfs(V);
        
        sb.append("\n");
        
        visited = new boolean[N+1];
        visited[V] = true;
        bfs(V);
        
        System.out.println(sb);
    }
    public static void dfs(int v){
        sb.append(v).append(" ");
        for(int u : graph[v]){
            if(!visited[u]){
                visited[u] = true;
                dfs(u);
            }
        }
    }
    public static void bfs(int v){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(v);
        
        while(!queue.isEmpty()){
            int n = queue.poll();
            sb.append(n).append(" ");
            for(int u : graph[n]){
                if(!visited[u]){
                    visited[u] = true;
                    queue.add(u);
                }
            }
        }
    }
}