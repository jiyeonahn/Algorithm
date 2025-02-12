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
        int n = 0;
        int m = 0;
        int idx = 0;
        while(n < N && m < M){
            if(A[n] < B[m]){
                merge[idx++] = A[n++];
            }else{
                merge[idx++] = B[m++];
            }
        }
        for(int i = n; i < N; i++){
            merge[idx++] = A[i];
        }
        for(int i = m; i < M; i++){
            merge[idx++] = B[i];
        }

        StringBuilder sb = new StringBuilder();
        for(int num : merge){
            sb.append(num).append(" ");
        }
        System.out.println(sb);
    }
}