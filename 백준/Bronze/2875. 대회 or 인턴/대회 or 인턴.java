import java.util.*;
import java.io.*;
class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int a = 0;
        int b = 0;

        int team = -1;
        while((N - a + M - b) >= K){
            team++;
            if((N-a) >= 2 && (M-b) >= 1){//대회에 나가는 사람
                a += 2;
                b += 1;
            }else{
                break;
            }
        }
        System.out.println(team);
    }
}