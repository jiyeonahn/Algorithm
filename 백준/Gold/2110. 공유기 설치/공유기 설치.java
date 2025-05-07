import java.util.*;
import java.io.*;
class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];

        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        int low = 1;
        int high = arr[N-1] - arr[0];

        int answer = 0;

        while(low <= high){
            int count = 1;
            int mid = (low+high)/2;
            int location = arr[0];
            for(int i = 1; i < N; i++){
                if(arr[i]-location >= mid){
                    count++;
                    location = arr[i];
                }
            }

            if(C <= count){
                low = mid + 1;
                answer = mid;
            }else{
                high = mid -1;
            }
        }

        System.out.println(answer);
    }
}