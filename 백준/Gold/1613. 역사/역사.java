import java.util.*;
import java.io.*;

class Main {
    static int INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[][] history = new int[n][n];

        for (int i = 0; i < n; i++) {
            Arrays.fill(history[i], INF);
            history[i][i] = 0;
        }

        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;

            history[a][b] = -1;
            history[b][a] = 1;
        }

        for (int t = 0; t < n; t++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (history[i][t] == -1 && history[t][j] == -1) {
                        history[i][j] = -1;
                    }
                    if (history[i][t] == 1 && history[t][j] == 1) {
                        history[i][j] = 1;
                    }
                }
            }
        }

        int s = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;

            if (history[a][b] == INF) {
                sb.append(0);
            } else {
                sb.append(history[a][b]);
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}