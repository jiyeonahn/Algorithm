import java.util.*;
import java.io.*;

class Main {
    static int[][] arr;
    static int N, first, second, third;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        arr = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        partition(0, 0, N);

        System.out.println(first);
        System.out.println(second);
        System.out.println(third);
    }

    public static void partition(int a, int b, int size) {
        if(a >= N || b >= N) return;
        if (partCheck(a, b, size)) {
            if (arr[a][b] == -1) {
                first++;
            }
            if (arr[a][b] == 0) {
                second++;
            }
            if (arr[a][b] == 1) {
                third++;
            }
            return;
        }

        int newSize = size/3;
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                partition(a+i*newSize,b+j*newSize,newSize);
            }
        }
    }

    public static boolean partCheck(int a, int b, int size) {
        int p = arr[a][b];
        for (int i = a; i < a + size; i++) {
            for (int j = b; j < b + size; j++) {
                if (arr[i][j] != p) {
                    return false;
                }
            }
        }
        return true;
    }
}