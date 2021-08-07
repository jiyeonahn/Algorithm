import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj11047 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        int cnt = 0;
        int N = Integer.parseInt(st.nextToken());
        int[] coin = new int[N];
        int K = Integer.parseInt(st.nextToken());

        for(int i = 0; i < N; i++)
            coin[i] = Integer.parseInt(br.readLine());

        for(int i = N - 1; i >= 0; i--){
            if(K == 0) break;
            if(K >= coin[i]) {
                cnt += K / coin[i];
                K %= coin[i];
            }
        }
        System.out.println(cnt);
    }
}
