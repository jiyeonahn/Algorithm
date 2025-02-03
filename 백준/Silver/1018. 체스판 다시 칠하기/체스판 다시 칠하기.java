import java.util.*;
import java.io.*;
class Main{
    static int minCount = Integer.MAX_VALUE;
    static char[][] chess;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        chess = new char[N][M];
        for(int i = 0; i < N; i++){
            chess[i] = br.readLine().toCharArray();
        }
        for(int i = 0; i < N - 7; i++){
            for(int j = 0; j < M - 7; j++){
                minCount = Math.min(checkBoard(i,j), minCount);
            }
        }
        System.out.println(minCount);
    }
    public static int checkBoard(int x, int y){
        String[] boardA = {"WBWBWBWB", "BWBWBWBW"};
        String[] boardB = {"BWBWBWBW", "WBWBWBWB"};
        int countA = 0;
        int countB = 0;
        for(int i = x; i < x+8; i++){
            for(int j = y; j < y+8; j++){
                if(chess[i][j] != boardA[i%2].charAt(j-y)){
                    countA++;
                }
            }
        }
        for(int i = x; i < x+8; i++){
            for(int j = y; j < y+8; j++){
                if(chess[i][j] != boardB[i%2].charAt(j-y)){
                    countB++;
                }
            }
        }
        return Math.min(countA, countB);
    }
}
