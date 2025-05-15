import java.util.*;
import java.io.*;
class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        char[][] board = new char[N][M];

        for(int i = 0; i < N; i++){
            board[i] = br.readLine().toCharArray();
        }

        int[][] white = new int[N][M];
        int[][] black = new int[N][M];

        char whiteStart = 'W';
        char blackStart = 'B';

        for(int i = 0; i < N; i++){
            if(i%2 == 0) {
                whiteStart = 'W';
                blackStart = 'B';
            }else{
                whiteStart = 'B';
                blackStart = 'W';
            }

            for(int j = 0; j < M; j++){
                if(board[i][j] != whiteStart){
                    white[i][j] = 1;
                }
                if(board[i][j] != blackStart){
                    black[i][j] = 1;
                }
                whiteStart = whiteStart == 'W' ? 'B' : 'W';
                blackStart = blackStart == 'B' ? 'W' : 'B';
            }
        }

        int[][] whiteSum = new int[N+1][M+1];
        int[][] blackSum = new int[N+1][M+1];
        for(int i = 1; i <= N; i++){
            for(int j = 1; j <= M; j++){
                whiteSum[i][j] = white[i-1][j-1] + whiteSum[i-1][j] + whiteSum[i][j-1] - whiteSum[i-1][j-1];
                blackSum[i][j] = black[i-1][j-1] + blackSum[i-1][j] + blackSum[i][j-1] - blackSum[i-1][j-1];
            }
        }

        int min = Integer.MAX_VALUE;
        for(int i = 1; i <= N-K+1; i++){
            for(int j = 1; j <= M-K+1; j++){
                int x1 = i;
                int y1 = j;
                int x2 = i+K-1;
                int y2 = j+K-1;

                int wSum = whiteSum[x2][y2] - whiteSum[x1-1][y2] - whiteSum[x2][y1-1] + whiteSum[x1-1][y1-1];
                int bSum = blackSum[x2][y2] - blackSum[x1-1][y2] - blackSum[x2][y1-1] + blackSum[x1-1][y1-1];

                min = Math.min(min, Math.min(wSum, bSum));
            }
        }

        System.out.println(min);
    }
}