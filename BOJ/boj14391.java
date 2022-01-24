import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj14391 {//종이 조각
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int num = N * M;

        int[][] arr = new int[N][M];

        for(int i = 0; i < N; i++){
           String str = br.readLine();
            for(int j = 0; j < M; j++){
                arr[i][j] = str.charAt(j)-'0';
            }
        }

        int answer = 0;
        for(int s = 0; s < (1 << num); s++){
            int max = 0;
            //가로 합
            for(int i = 0; i < N; i++){
                int sum = 0;
                for(int j = 0; j < M; j++){
                    int k = i * M + j;
                    if((s & (1 << k)) == 0){
                        sum = sum * 10 + arr[i][j];
                    }else{
                        max += sum;
                        sum = 0;
                    }
                }
                max += sum;
            }

            //세로 합
            for(int j = 0; j < M; j++){
                int sum = 0;
                for(int i = 0; i < N; i++){
                    int k = i * M + j;
                    if((s & (1 << k)) != 0){
                        sum = sum * 10 + arr[i][j];
                    }else{
                        max += sum;
                        sum = 0;
                    }
                }
                max += sum;
            }
            answer = Math.max(answer, max);
        }
        System.out.println(answer);
    }
}