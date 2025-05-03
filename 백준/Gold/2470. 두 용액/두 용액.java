import java.util.*;
import java.io.*;
class Main{
    static int min = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        int[] answer = new int[2];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int left = 0;
        int right = N-1;

        while(left < right){
            int diff = Math.abs(arr[right] + arr[left]);

            if(diff < min){
                min = diff;
                answer[0] = arr[left];
                answer[1] = arr[right];
            }

            if(diff == 0) break;

            if(arr[right] + arr[left] < 0){
                left++;
            }else if(arr[right] + arr[left] > 0){
                right--;
            }
        }

        System.out.println(answer[0] + " " + answer[1]);
    }
}