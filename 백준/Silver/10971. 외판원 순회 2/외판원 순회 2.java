import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {//외판원 순회 2
    private static int N, min = 10000000;
    private static int[][] W;
    private static boolean[] visited;

    public static void dfs(int idx, int sum, int len){
        if(len == N && W[idx][0] != 0){
            min = Math.min(min, sum + W[idx][0]);
            return;
        }

        for(int j = 0; j < N; j++){
            if(W[idx][j] != 0 && !visited[j]){
                visited[j] = true;
                dfs(j,sum + W[idx][j], len+1);
                visited[j] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        W = new int[N][N];
        visited = new boolean[N];

        StringTokenizer st;
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine()," ");
            for(int j = 0; j < N; j++){
                W[i][j] =Integer.parseInt(st.nextToken());
            }
        }
        visited[0] = true;
        dfs(0,0,1);

        System.out.println(min);
    }
}