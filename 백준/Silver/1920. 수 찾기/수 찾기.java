import java.util.*;
import java.io.*;
class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0; i < N; i++){
            A[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(A);

        int M = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < M; i++){
            int n = Integer.parseInt(st.nextToken());

            int left = 0;
            int right = N-1;

            boolean isExist = false;
            while(left <= right){
                int mid = (left+right)/2;
                if(n==A[mid]){
                    isExist = true;
                    break;
                }
                if(n < A[mid]){
                    right = mid - 1;
                }else if(n > A[mid]){
                    left = mid + 1;
                }
            }

            if(isExist){
                sb.append("1").append("\n");
            }else{
                sb.append("0").append("\n");
            }
        }
        System.out.println(sb);
    }
}