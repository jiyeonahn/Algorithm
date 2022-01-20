import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj15661 {//링크와 스타트
    private static int[][] arr;
    private static boolean[] visited;
    private static int N, min = 2000;

    public static void diff(){
        int start = 0;
        int link = 0;

        for(int i = 0; i < N; i++){
            for(int j = i+1; j < N; j++){
                if(visited[i] && visited[j]){
                    start += arr[i][j] + arr[j][i];
                }
                else if(!visited[i] && !visited[j]){
                    link += arr[i][j] + arr[j][i];
                }
            }
        }

        min = Math.min(min, Math.abs(start - link));

    }

    public static void dfs(int idx, int len) {
        if(len >= 1 && len <= N){
            diff();
            if(len == N){
                return;
            }
        }
        for(int i = idx; i < N; i++){
            if(!visited[i]){
                visited[i] = true;
                dfs(i + 1, len + 1);
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        visited = new boolean[N];

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0, 0);

        System.out.println(min);
    }

}