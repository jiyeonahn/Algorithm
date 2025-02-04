import java.util.*;
import java.io.*;
class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int E = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int e,s,m;
        for(int i = 1; i <= 7980; i++){
            e = i%15==0 ? 15 : i%15;
            s = i%28==0 ? 28 : i%28;
            m = i%19==0 ? 19 : i%19;

            if(e == E && s == S && m == M){
                System.out.println(i);
                break;
            }
        }
    }
}