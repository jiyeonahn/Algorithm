import java.util.*;
import java.io.*;
class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] house = new int[N];

        for(int i = 0; i < N; i++){
            house[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(house);

        int answer = 0;
        int low = 1;
        int high = house[N-1] - house[0]; // 최대거리
        while(low<=high){
            int mid = (low+high)/2;


            int lastPosition = house[0];
            int count = 1;
            for(int i = 1; i < N; i++){
                if(house[i]-lastPosition >= mid){
                    count++;
                    lastPosition = house[i];
                }
            }

            if(count < M){//설치 할 수 있는 공유기가 적다면 => 거리 줄여야함
                high = mid - 1;
            }else{//설치 할 수 있는 공유기가 적다면 => 거리 늘려야 함
                low = mid + 1;
                answer = mid;
            }
        }
        System.out.println(answer);
    }
}