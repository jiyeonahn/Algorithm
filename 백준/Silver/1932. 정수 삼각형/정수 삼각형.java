import java.io.*;
import java.util.*;
class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n+1][n+1];
        int[][] triangle = new int[n+1][n+1];

        for(int i = 1; i <= n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= i; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int answer = 0;

        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= i; j++){
                triangle[i][j] = Math.max(arr[i][j] + triangle[i-1][j-1], arr[i][j] + triangle[i-1][j]);
                answer = Math.max(answer, triangle[i][j]);
            }
        }
        System.out.println(answer);
    }
}