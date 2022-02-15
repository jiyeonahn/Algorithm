import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj14225 {//부분수열의 합
    static int max = 100000 * 20;
    static int N, answer;
    static int[] arr;
    static boolean[] visited = new boolean[max + 1];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        dfs(0,0);

        while(visited[answer]){
            answer++;
        }

        System.out.println(answer);
    }
    private static void dfs(int idx, int sum){
        if(idx == N){
            visited[sum] = true;
            return;
        }
        dfs(idx + 1,sum + arr[idx]);
        dfs(idx + 1, sum);
    }

}