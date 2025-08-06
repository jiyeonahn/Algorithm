import java.util.*;
import java.io.*;
class Main{
    static int INF = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        int[][] weight = new int[N][N];

        for(int i = 0; i < N; i++){
            Arrays.fill(weight[i], INF);
            weight[i][i] = 0;
        }

        StringTokenizer st;
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken())-1;
            int b = Integer.parseInt(st.nextToken())-1;

            weight[a][b] = 1;
            weight[b][a] = -1;
        }

        for(int k = 0; k < N; k++){
            for(int i = 0; i < N; i++){
                for(int j = 0; j < N; j++){
                    if(weight[i][k] == 1 && weight[k][j] == 1){
                        weight[i][j] = 1;
                    }
                    if(weight[i][k] == -1 && weight[k][j] == -1){
                        weight[i][j] = -1;
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < N; i++){
            int cnt = 0;
            for(int j = 0; j < N; j++){
                if(weight[i][j] == INF){
                    cnt++;
                }
            }
            sb.append(cnt).append("\n");
        }
        System.out.println(sb);
    }
}