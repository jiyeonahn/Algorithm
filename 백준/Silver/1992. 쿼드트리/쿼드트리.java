import java.util.*;
import java.io.*;
class Main{
    static int[][] arr;
    static int N;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];

        for(int i = 0; i < N; i++){
            String str = br.readLine();
            for(int j = 0; j < N; j++){
                arr[i][j] = str.charAt(j) - '0';
            }
        }
        compression(0,0, N);
        System.out.println(sb);
    }

    public static void compression(int a, int b, int size) {
        if(a >= N || b >= N) return;
        if(isPossible(a,b,size)){ //압축이 되는지???
            sb.append(arr[a][b]);
            return;
        } //압축이 안 된다면? -> 다시 4분할
        sb.append("(");
        int newSize = size/2;
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                compression(a+i*newSize,b+j*newSize, newSize);
            }
        }
        sb.append(")");
    }

    public static boolean isPossible(int a, int b, int size){
        for(int i = a; i < a+size; i++){
            for(int j = b; j < b+size; j++){
                if(arr[i][j] != arr[a][b]){
                    return false;
                }
            }
        }
        return true;
    }
}