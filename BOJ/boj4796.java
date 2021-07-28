import java.io.*;
import java.util.StringTokenizer;

public class boj4796 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int i = 0;
        while(true){
            i++;
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            int L = Integer.parseInt(st.nextToken());
            int P = Integer.parseInt(st.nextToken());
            int V = Integer.parseInt(st.nextToken());
            if(L == 0) break;
            if(V % P > L)
                bw.write("Case " + i + ": " + (L * (V / P) + L) + "\n");
            else
                bw.write("Case " + i + ": " + (L * (V / P) + (V % P)) + "\n");
        }

        bw.flush();
        bw.close();
    }
}