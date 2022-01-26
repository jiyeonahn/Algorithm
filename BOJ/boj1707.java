import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.Queue;

public class boj1707 {//이분 그래프
    private static int[] color;
    private static String answer;
    private static ArrayList<Integer>[] graph;
    private static Queue<Integer> q;

    public static boolean bfs(int node) {
        color[node] = 1;
        q.add(node);
        while(!q.isEmpty()){
            int n = q.poll();

            for(int num : graph[n]){
                if(color[num] == 0){
                    color[num] = (color[n] == 1 ? 2 : 1);
                    q.add(num);
                }else if(color[num] == color[n]) {
                    answer = "NO";
                    return false;
                }
            }
        }
        answer = "YES";
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine());

        for(int i = 0; i < K; i++){
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            int V = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());


            color = new int[V];//0:방문 x, 1: 초기색깔, 2:다른색

            graph = new ArrayList[V];
            for (int j = 0; j < V; j++) {
                graph[j] = new ArrayList<>();
            }

            for (int j = 0; j < E; j++) {
                st = new StringTokenizer(br.readLine());

                int u = Integer.parseInt(st.nextToken())-1;
                int v = Integer.parseInt(st.nextToken())-1;

                graph[u].add(v);
                graph[v].add(u);
            }

            q = new LinkedList<>();
            for(int j = 0; j < V; j++){
                if(color[j] == 0){
                    if(!bfs(j))
                        break;
                }
            }

            System.out.println(answer);
        }
    }
}