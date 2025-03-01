import java.util.*;
import java.io.*;
class Main{
    static long[][] sum;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] arr = new int[N+1][M+1];
        for(int i = 1; i <= N; i++){
            String str = br.readLine();
            for(int j = 1; j <= M; j++){
                arr[i][j] = str.charAt(j-1) - '0';
            }
        }

        sum = new long[N+1][M+1];
        for(int i = 1; i <= N; i++){
            for(int j = 1; j <= M; j++){
                sum[i][j] = sum[i-1][j] + sum[i][j-1] - sum[i-1][j-1] + arr[i][j];
            }
        }

        long answer = 0;
        for(int i = 1; i <= M-2; i++){
            for(int j = i+1; j <= M-1; j++){
                long sum1 = sum(1,1,N,i);
                long sum2 = sum(1,i+1,N,j);
                long sum3 = sum(1,j+1,N,M);
                answer = Math.max(answer, sum1*sum2*sum3);
            }
        }

        for(int i = 1; i <= N-2; i++){
            for(int j = i+1; j <= N-1; j++){
                long sum1 = sum(1,1,i,M);
                long sum2 = sum(i+1,1,j,M);
                long sum3 = sum(j+1,1,N,M);
                answer = Math.max(answer, sum1*sum2*sum3);
            }
        }

        for(int i = 1; i <= N-1; i++){
            for(int j = 1; j <= M-1; j++){
                long sum1 = sum(1,1,N,j);
                long sum2 = sum(1,j+1,i,M);
                long sum3 = sum(i+1,j+1,N,M);
                answer = Math.max(answer, sum1*sum2*sum3);
            }
        }

        for(int i = 1; i <= N-1; i++){
            for(int j = 1; j <= M-1; j++){
                long sum1 = sum(1,1,i,j);
                long sum2 = sum(i+1,1,N,j);
                long sum3 = sum(1,j+1,N,M);
                answer = Math.max(answer, sum1*sum2*sum3);
            }
        }

        for(int i = 1; i <= N-1; i++){
            for(int j = 1; j <= M-1; j++){
                long sum1 = sum(1,1,i,M);
                long sum2 = sum(i+1,1,N,j);
                long sum3 = sum(i+1,j+1,N,M);
                answer = Math.max(answer, sum1*sum2*sum3);
            }
        }

        for(int i = 1; i <= N-1; i++){
            for(int j = 1; j <= M-1; j++){
                long sum1 = sum(1,1,i,j);
                long sum2 = sum(1,j+1,i,M);
                long sum3 = sum(i+1,1,N,M);
                answer = Math.max(answer, sum1*sum2*sum3);
            }
        }

        System.out.println(answer);
    }
    public static long sum(int a, int b, int c, int d){
        return sum[c][d] - sum[a-1][d] - sum[c][b-1] + sum[a-1][b-1];
    }
}