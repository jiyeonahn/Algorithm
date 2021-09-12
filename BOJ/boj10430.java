import java.io.*;
import java.util.StringTokenizer;

public class boj10430 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        bw.write((A+B)%C + "\n");
        bw.write(((A%C)+(B%C))%C + "\n");
        bw.write((A*B)%C + "\n");
        bw.write(((A%C)*(B%C))%C + "\n");

        bw.flush();
        bw.close();
    }
}