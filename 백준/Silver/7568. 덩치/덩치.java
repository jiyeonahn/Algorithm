import java.util.*;
import java.io.*;
class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] weight = new int[N];
        int[] height = new int[N];
        int[] rank = new int[N];

        StringTokenizer st;
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            weight[i] = x;
            height[i] = y;
        }

        for(int i = 0; i < N; i++){
            int x = weight[i];
            int y = height[i];
            int k = 0;
            for(int j = 0; j < N; j++){
                if(i == j) continue;
                if(weight[j] > x && height[j] > y){
                    k++;
                }
            }
            rank[i] = k+1; //덩치 등수
        }

        StringBuilder sb = new StringBuilder();
        for(int n : rank){
            sb.append(n).append(" ");
        }

        System.out.println(sb);
    }
}