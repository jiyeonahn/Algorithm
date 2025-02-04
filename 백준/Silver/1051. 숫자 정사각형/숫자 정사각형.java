import java.util.*;
import java.io.*;
class Main{
    static int N,M;
    static int[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        for(int i = 0; i < N; i++){
            String str = br.readLine();
            for(int j = 0; j < M; j++){
                arr[i][j] = str.charAt(j) - '0';
            }
        }
        int max = 1;
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                max = Math.max(max, rectangle(i,j));
            }
        }
        System.out.println(max);
    }
    public static int rectangle(int a, int b){
        int n = arr[a][b];
        int h,w;
        int area = 0;

        for(int i = a+1; i < N; i++){
            if(arr[i][b] == n){
                h = i-a+1;
                for(int j = b+1; j < M; j++){
                    if(arr[a][j] == n && arr[i][j] == n){
                        w = j-b+1;
                        if(h==w){
                            area = Math.max(area, h*w);
                        }
                    }
                }
            }
        }
        return area;
    }
}