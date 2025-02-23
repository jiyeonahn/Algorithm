import java.util.*;
import java.io.*;
class Main{
    static boolean[] visited;
    static int[] circle;
    static int count;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < T; i++){
            count = 0;
            int N = Integer.parseInt(br.readLine());
            circle = new int[N+1];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 1; j < N+1; j++){
                circle[j] = Integer.parseInt(st.nextToken());
            }
            visited = new boolean[N+1];
            for(int j = 1; j < N+1; j++){
                if(!visited[j]){
                    count++;
                    dfs(j);
                }
            }
            sb.append(count).append("\n");
        }
        System.out.print(sb);
    }
    public static void dfs(int current){
        if(visited[current]){
            return;
        }
        visited[current] = true;
        dfs(circle[current]);
    }
}