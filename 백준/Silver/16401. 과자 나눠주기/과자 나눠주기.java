import java.util.*;
import java.io.*;
class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());//조카의 수
        int N = Integer.parseInt(st.nextToken());//과자의 수

        int[] snack = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            snack[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(snack);

        int low = 1;
        int high = snack[N-1];

        int answer = 0;

        while(low <= high){
            int mid = (low + high)/2;
            int cnt = 0;
            for(int s : snack){
                if(s >= mid){
                    cnt += s/mid;
                }
            }
            if(cnt >= M){
                low = mid + 1;
                answer = mid;
            }else{
                high = mid - 1;
            }
        }

        System.out.println(answer);
    }
}