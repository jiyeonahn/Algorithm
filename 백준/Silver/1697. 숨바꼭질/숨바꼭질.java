import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {//숨바꼭질

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] lc = new int[3];
        int[] ans = new int[100001];

        Queue<Integer> q = new LinkedList<>();
        q.add(N);

        while (!q.isEmpty()) {
            int n = q.poll();

            if(n == K) {
                System.out.println(0);
                break;
            }

            lc[0] = n + 1;
            lc[1] = n - 1;
            lc[2] = n * 2;

            for (int i = 0; i < 3; i++) {
                if (lc[i] >= 0 && lc[i] <= 100000 && ans[lc[i]] == 0) {
                    ans[lc[i]] = ans[n] + 1;
                    if (lc[i] == K) {
                        System.out.println(ans[lc[i]]);
                        q.clear();
                        break;
                    }
                    q.add(lc[i]);
                }
            }
        }
    }

}