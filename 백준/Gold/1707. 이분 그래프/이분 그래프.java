import java.util.*;
import java.io.*;
class Main{
    static StringBuilder answer = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for(int i = 0; i < K; i++){
            st = new StringTokenizer(br.readLine());
            int V = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());
            //ArrayList를 요소로 갖는 배열
            ArrayList<Integer>[] graph = new ArrayList[V];
            for(int j = 0; j < V; j++){
                graph[j] = new ArrayList<>();
            }
            for(int j = 0; j < E; j++){
                st = new StringTokenizer(br.readLine());
                int node1 = Integer.parseInt(st.nextToken()) - 1;
                int node2 = Integer.parseInt(st.nextToken()) - 1;

                graph[node1].add(node2);
                graph[node2].add(node1);
            }
            int[] colors = new int[V];
            boolean result = true;
            for(int j = 0; j < V; j++){
                if(colors[j] == 0){
                    if(!bfs(j, graph, colors)){
                        result = false;
                        break;
                    }
                }
            }
            answer.append(result ? "YES" : "NO").append("\n");
        }
        System.out.println(answer);
    }
    public static boolean bfs(int n, ArrayList<Integer>[] graph, int[] colors){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(n);
        colors[n] = 1;

        while(!queue.isEmpty()){
            int current = queue.poll();
            for(int g : graph[current]){
                if(colors[g] == colors[current]){
                    return false;
                }
                if(colors[g] == 0){
                    colors[g] = -colors[current];
                    queue.add(g);
                }
            }
        }
        return true;
    }
}