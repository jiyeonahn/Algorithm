import java.util.*;
import java.io.*;
class Main{
    static int count;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        hanoi(N, 1, 3, 2);
        System.out.println(count);
        System.out.println(sb);
    }
    public static void hanoi(int n, int start, int end, int via){
        count++;
        if(n == 1){
            sb.append(start).append(" ").append(end).append("\n");
            return;
        }
        //1)n-1개를 보조기둥으로 옮긴다.
        hanoi(n-1, start, via, end);
        //2)n을 도착기둥으로 옮긴다.
        sb.append(start).append(" ").append(end).append("\n");
        //3)n-1개를 보조기둥에서 도착기둥으로 옮긴다.
        hanoi(n-1, via, end, start);
    }
}