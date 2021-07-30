import java.io.*;
import java.util.StringTokenizer;

public class boj15904 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String ucpc = "UCPC";
        String str = br.readLine();
        int i = 0;
        int j = 0;
        while(true){
            if(ucpc.charAt(i) == str.charAt(j))
                i++;
            if(i == 4 || j == str.length()-1) break;
            j++;
        }

        bw.write(i== 4 ? "I love UCPC" : "I hate UCPC");
        bw.flush();
        bw.close();
    }
}