import java.io.*;
import java.util.StringTokenizer;

public class boj11723 {//집합
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int M = Integer.parseInt(br.readLine());
        StringTokenizer st;

        int S = 0;

        for(int i = 0; i < M ; i++){
            st = new StringTokenizer(br.readLine(), " ");
            String operation = st.nextToken();
            int n = 0;
            switch (operation){
                case "add":
                    n = Integer.parseInt(st.nextToken());
                    S |= 1 << n;
                    break;
                case "remove":
                    n = Integer.parseInt(st.nextToken());
                    S &= ~(1 << n);
                    break;
                case "check":
                    n = Integer.parseInt(st.nextToken());
                    if((S & (1 << n)) == 0){
                        sb.append(0).append("\n");
                    }else sb.append(1).append("\n");
                    break;
                case "toggle":
                    n = Integer.parseInt(st.nextToken());
                    if((S & (1 << n)) == 0){
                        S |= 1 << n;
                    }else S &= ~(1 << n);
                    break;
                case "all":
                    S = (1 << 21) -1;
                    break;
                case "empty":
                    S = 0;
                    break;
            }
        }
        System.out.println(sb.toString());
    }
}