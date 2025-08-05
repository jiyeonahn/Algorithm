import java.util.*;
import java.io.*;

class Main {
    static int INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] student = new int[N][N];

        for (int i = 0; i < N; i++) {
            Arrays.fill(student[i], INF);
            student[i][i] = 0;
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;

            student[a][b] = 1;
            student[b][a] = -1;
        }

        for (int k = 0; k < N; k++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (student[i][k] == 1 && student[k][j] == 1) {
                        student[i][j] = 1;
                    }
                    if (student[i][k] == -1 && student[k][j] == -1) {
                        student[i][j] = -1;
                    }
                }
            }
        }

        int answer = 0;
        for (int i = 0; i < N; i++) {
            boolean know = true;
            for (int j = 0; j < N; j++) {
                if (student[i][j] == INF) {
                    know = false;
                    break;
                }
            }
            if (know) {
                answer++;
            }
        }
        System.out.println(answer);
    }
}