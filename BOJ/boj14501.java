import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj14501 {//퇴사
private static int[] time, pay;
private static int N, max;

    public static void dfs(int t, int p){
        if (t >= N){
            max = Math.max(max, p);
            return;
        }
        if (t + time[t] <= N)
            dfs(t + time[t], p + pay[t]);
        else
            dfs(t + time[t], p);
        dfs(t+1, p);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        time = new int[N];
        pay = new int[N];

        StringTokenizer st;
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            time[i] = Integer.parseInt(st.nextToken());
            pay[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0,0);

        System.out.println(max);
    }

}