import java.util.*;
import java.io.*;

class Main {
    static int INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());// 지역 개수
        int m = Integer.parseInt(st.nextToken());// 수색 범위
        int r = Integer.parseInt(st.nextToken());// 길의 개수

        st = new StringTokenizer(br.readLine());

        int[] item = new int[n];

        for (int i = 0; i < n; i++) {
            item[i] = Integer.parseInt(st.nextToken());
        }

        int[][] dist = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], INF);
            dist[i][i] = 0;
        }

        for (int i = 0; i < r; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            int l = Integer.parseInt(st.nextToken());

            dist[a][b] = l;
            dist[b][a] = l;
        }

        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if(dist[i][k] != INF && dist[k][j] != INF){
                        dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                    }
                }
            }
        }

        int answer = 0;
        for (int i = 0; i < n; i++) {
            int sum = item[i];
            for (int j = 0; j < n; j++) {
                if (i != j && dist[i][j] <= m) {
                    sum += item[j];
                }
            }
            answer = Math.max(answer, sum);
        }

        System.out.println(answer);
    }
}