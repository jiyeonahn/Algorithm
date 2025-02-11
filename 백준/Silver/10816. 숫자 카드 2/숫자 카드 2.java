import java.util.*;
import java.io.*;
class Main{
    static int[] card;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        card = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0; i < N; i++){
            card[i] = Integer.parseInt(st.nextToken());
        }

        int M = Integer.parseInt(br.readLine());
        int[] num = new int[M];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < M; i++){
            num[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(card);
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < M; i++){
            int target = num[i];
            int low = 0;
            int high = N-1;
            
            int startIndex = lower_bound(low, high, target);

            if(startIndex >= 0){
                int endIndex = upper_bound(low, high, target);
                sb.append(endIndex-startIndex).append(" ");
            }else{
                sb.append(0).append(" ");
            }

        }
        System.out.println(sb);
    }

    public static int lower_bound(int low, int high, int target){// target이 가장 먼저 나오는 위치
        int location = -1;
        while(low<=high){
            int mid = (low+high)/2;
            if(card[mid] < target){//mid를 높여야함
                low = mid+1;
            }else if(card[mid] >= target){//mid값을 낮춰야함
                high = mid-1;
                if(card[mid] == target){
                    location = mid;
                }
            }
        }
        return location;
    }

    public static int upper_bound(int low, int high, int target) {// 처음으로 target이 아닌 다른 수가 나오는 위치
        int location = -1;
        while(low<=high){
            int mid = (low+high)/2;
            if(card[mid] <= target){//mid를 높여야함
                low = mid+1;
                location = mid;
            }else if(card[mid] > target){//mid값을 낮춰야함
                high = mid-1;
            }
        }
        return location+1;
    }
}