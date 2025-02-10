import java.util.*;
import java.io.*;
class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        long low = 1;
        long high = arr[N-1];

        long answer = 0;

        while(low<=high){
            long sum = 0;
            long mid = (low+high)/2;
            for(int i = 0; i < N; i++){
                if(arr[i] > mid){
                    sum += arr[i] - mid;
                }
            }
            if(sum >= M){
                low = mid + 1; //절단기에서 설정할 수 있는 높이를 올린다.
                answer = mid;
            }else{
                high = mid -1;
            }

        }
        System.out.println(answer);
    }
}
