import java.io.*;
import java.util.Arrays;
import java.util.Collections;

public class boj2217 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        Integer[] arr = new Integer[N];

        for(int i = 0; i < N; i++)
            arr[i] = Integer.parseInt(br.readLine());

        Arrays.sort(arr, Collections.reverseOrder());

        int max = arr[0];
        for(int i = 1; i < N; i++){
            if(arr[i] * (i+1) > max){
                max = arr[i] * (i+1);
                break;
            }
        }

        System.out.println(max);
    }
}
