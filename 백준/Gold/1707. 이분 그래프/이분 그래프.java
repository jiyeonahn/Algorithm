import java.util.*;
import java.io.*;
class Main{
    static int[] visited;
    static int V;
    static ArrayList<Integer>[] graph;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < K; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            V = Integer.parseInt(st.nextToken());//정점의 개수
            int E = Integer.parseInt(st.nextToken());//간선의 개수

            graph = new ArrayList[V+1];

            for(int j = 0; j < V+1; j++){
                graph[j] = new ArrayList<>();
            }

            for(int j = 0; j < E; j++){
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                graph[a].add(b);
                graph[b].add(a);
            }

            boolean isBipartiteGraph = true;

            visited = new int[V+1];//-1은 왼쪽, 1은 오른쪽

            for(int j = 1; j < V+1; j++){
                if(visited[j] == 0){
                    if(!isBipartiteGraph(j)){
                        isBipartiteGraph = false;
                        break;
                    }
                }
            }

            sb.append(isBipartiteGraph ? "YES" : "NO").append("\n");
        }
        System.out.println(sb);
    }
    public static boolean isBipartiteGraph(int n){
        Queue<Integer> queue = new LinkedList<>();
        
        queue.add(n);
        visited[n] = -1;

        while(!queue.isEmpty()){
            int m = queue.poll();
            for(int num : graph[m]){
                if(visited[num] == visited[m]){
                    return false;
                }
                if(visited[num] == 0){
                    queue.add(num);
                    visited[num] = -visited[m];
                }
            }
        }

        return true;
    }
}