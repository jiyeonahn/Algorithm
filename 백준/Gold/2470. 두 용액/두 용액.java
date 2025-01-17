import java.util.*;
import java.io.*;
class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        int[] answer = new int[2];

        int left = 0;
        int right = N-1;
        int min = Integer.MAX_VALUE;
        answer[0] = arr[left];
        answer[1] = arr[right];

        while(left < right){
            int sum = arr[left] + arr[right];
            if(Math.abs(sum) < min){
                min = Math.abs(sum);
                answer[0] = arr[left];
                answer[1] = arr[right];
                if(min == 0) break;
            }
            if(sum < 0){
                left++;
            }else{
                right--;
            }
        }

        System.out.println(answer[0] + " " + answer[1]);
    }
}