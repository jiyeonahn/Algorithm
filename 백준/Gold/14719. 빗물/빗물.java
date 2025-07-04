import java.util.*;
import java.io.*;
class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());

        int[] height = new int[W];

        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < W; i++){
            height[i] = Integer.parseInt(st.nextToken());
        }

        int answer = 0;

        int max = 0;
        for(int i = 1; i < W-1; i++){
            int now = height[i];
            int left = 0;
            int right = 0;

            for(int j = 0; j < i; j++){
                left = Math.max(left, height[j]);
            }

            for(int j = i+1; j < W; j++){
                right = Math.max(right, height[j]);
            }

            int min = Math.min(left, right);

            if(now < min){
                answer += min - now;
            }
        }

        System.out.println(answer);
    }
}