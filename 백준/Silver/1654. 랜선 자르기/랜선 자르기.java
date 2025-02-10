import java.util.*;
import java.io.*;
class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int[] arr = new int[K];

        for(int i = 0; i < K; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        long low = 1; //mid가 0이 되면 안 되므로
        long high = arr[K-1];

        long answer = 0;

        while(low <= high){
            long mid = (low+high)/2;
            long cnt = 0;
            for(int i = 0; i < K; i++){
                cnt += arr[i]/mid;
            }

            if(cnt >= N){ // 현재 mid 길이로 N개 이상을 만들 수 있음, 현재 길이보다 더 긴 길이로 만들 수 있음
                low = mid+1; // 더 긴 길이 시도
                answer = mid;
            }else{
                high = mid-1; // 더 짧은 길이 시도
            }
        }
        System.out.println(answer);
    }
}