import java.util.*;
import java.io.*;
class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] A = new int[N];
        int[] B = new int[M];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            A[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < M; i++){
            B[i] = Integer.parseInt(st.nextToken());
        }

        int[] merge = new int[N+M];
        for(int i = 0; i < N; i++){
            merge[i] = A[i];
        }

        for(int i = 0; i < M; i++){
            merge[i+N] = B[i];
        }

        Arrays.sort(merge);

        StringBuilder sb = new StringBuilder();
        for(int n : merge){
            sb.append(n).append(" ");
        }
        System.out.println(sb);
    }
}