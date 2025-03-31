import java.util.*;
import java.io.*;
//플로이드 워셜
class Main{
    static int INF = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] friend = new int[N+1][N+1];
        for(int i = 0; i <= N; i++){
            Arrays.fill(friend[i], INF);
            friend[i][i] = 0;
        }

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            friend[A][B] = 1;
            friend[B][A] = 1;
        }

        for(int k = 1; k <= N; k++){//중간다리
            for(int i = 1; i <= N; i++){//시작
                for(int j = 1; j <= N; j++){//끝
                    if(friend[i][k] != INF && friend[k][j] != INF){
                        friend[i][j] = Math.min(friend[i][j], friend[i][k]+friend[k][j]);
                    }
                }
            }
        }

        int answer = INF;
        int idx = 0;

        for(int i = 1; i <= N; i++){
            int sum = 0;
            for(int j = 1; j <= N; j++){
                sum += friend[i][j];
            }
            if(sum < answer){
                idx = i;
                answer = sum;
            }
        }

        System.out.println(idx);
    }
}