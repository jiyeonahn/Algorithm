import java.util.*;
import java.io.*;

class Main {
    static int min;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        int INF = Integer.MAX_VALUE;
        StringTokenizer st;

        int[][] bus = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            Arrays.fill(bus[i], INF);
            bus[i][i] = 0;
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            bus[a][b] = Math.min(bus[a][b], c);
        }

        for (int k = 1; k <= n; k++) { //거쳐가는 노드
            for (int i = 1; i <= n; i++) { //시작점
                for (int j = 1; j <= n; j++) { //도착점
                    if (bus[i][k] != INF && bus[k][j] != INF) {
                        bus[i][j] = Math.min(bus[i][j], bus[i][k] + bus[k][j]);
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (bus[i][j] == INF) {
                    sb.append(0).append(" ");
                } else {
                    sb.append(bus[i][j]).append(" ");
                }
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}