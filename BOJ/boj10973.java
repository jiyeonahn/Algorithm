import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class boj10973 {//이전 순열
    private static int[] arr;
    private static StringBuilder sb = new StringBuilder();
    private static int N, idx;

    public static boolean nextPermutation(){
        if(N == 1) return false;
        for(int i = N-1; i > 0; i--){
            if(arr[i] < arr[i-1]){
                idx = i;
                break;
            }
            if(i == 1) return false;
        }

        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        if(nextPermutation()){
            for(int i  = N-1; i >= idx; i--){
                if(arr[idx-1] > arr[i]){
                    int temp = arr[i];
                    arr[i] = arr[idx-1];
                    arr[idx-1] = temp;
                    break;
                }
            }
            Integer[] right = new Integer[N-idx];
            int ri = 0;

            for(int i  = N-1; i >= idx; i--){
                right[ri] = arr[i];
                ri++;
            }

            Arrays.sort(right, Collections.reverseOrder());

            for(int i = 0; i < idx; i++){
                sb.append(arr[i]).append(" ");
            }

            for (int value : right) {
                sb.append(value).append(" ");
            }

            System.out.println(sb.toString());
        }
        else System.out.println(-1);

    }
}