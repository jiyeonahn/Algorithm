import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj1182_2 {//부분수열의 합_부르트포스
    static int[] arr;
    static int answer, N, S;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        arr = new int[N];

        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0, 0);

        answer = (S == 0) ? answer - 1 : answer;
        System.out.println(answer);
    }
    private static void dfs(int idx, int sum){
        if(idx == N) {
            if(sum == S) answer++;
            return;
        }
        dfs(idx + 1,sum + arr[idx]);
        dfs(idx + 1, sum);
    }
}
