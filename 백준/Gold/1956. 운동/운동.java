import java.util.*;
import java.io.*;
class Main{
    static final int INF = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        int[][] town = new int[V+1][V+1];
        for(int i = 0; i <= V; i++){
            Arrays.fill(town[i], INF);
        }

        for(int i = 0; i < E; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            town[a][b] = c;
        }

        for(int k = 0; k <= V; k++){
            for(int i = 0; i <= V; i++){
                for(int j = 0; j <= V; j++){
                    if(town[i][k] != INF && town[k][j] != INF){
                        town[i][j] = Math.min(town[i][j], town[i][k] + town[k][j]);
                    }
                }
            }
        }

        int min = INF;
        for(int i = 0; i <= V; i++){
            if(town[i][i] != INF){
                min = Math.min(min, town[i][i]);
            }
        }

        System.out.println(min == INF ? -1 : min);
    }
}