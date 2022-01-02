import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class boj2309 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = new int[9];
        int sum = 0;
        for(int i = 0; i < 9; i++){
            arr[i] = Integer.parseInt(br.readLine());
            sum += arr[i];
        }
        Arrays.sort(arr);
        for(int i = 8; i > 0; i--){
            for(int j = i-1; j >= 0; j--){
                if(sum - arr[i] - arr[j] == 100){
                    arr[i] = -1;
                    arr[j] = -1;
                }
            }
            if(arr[i] == -1) break;
        }

        for(int i = 0; i <= 8; i++){
            if(arr[i] == -1) continue;
            System.out.println(arr[i]);
        }
    }
}