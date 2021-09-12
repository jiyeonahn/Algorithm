import java.io.*;
import java.util.StringTokenizer;

public class boj1934 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            bw.write(a * b / gcd(a,b) + "\n");
        }

        bw.flush();
        bw.close();
    }
    public static int gcd(int a, int b){
        if(b == 0) return a;
        return gcd(b, a % b);
    }
}