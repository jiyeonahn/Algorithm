import java.io.*;
import java.util.StringTokenizer;

public class boj6064 {//카잉달력
    public static int gcd(int a, int b){
        if(a == 0)
            return b;
        return gcd(b % a, a);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        for(int i = 0; i < T; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            int lcm = M * N / gcd(M,N);//멸망년도

            int k = x;
            y = y%N;//N은 항상 y보다 크다. y==N인경우 k%N은 0이 나올 수밖에 없다.
            while(k <= lcm){
                if(k%N == y){
                    break;
                }
                k += M;
            }
            if(k > lcm)
                bw.write(-1 + "\n");
            else
                bw.write(k + "\n");
        }
        bw.flush();
        bw.flush();
    }
}