import java.io.*;
import java.util.Stack;

public class boj10828 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        Stack st = new Stack();

        String cmd;
        for(int i = 0; i < N; i++){
            cmd = br.readLine();
            if(cmd.length() >= 6)
                st.push(cmd.substring(5));
            else if(cmd.equals("pop")){
                if(st.empty()) bw.write(-1 + "\n");
                else bw.write(st.pop() + "\n");
            }
            else if(cmd.equals("size")){
                bw.write(st.size() + "\n");
            }
            else if(cmd.equals("empty")){
                if(st.empty()) bw.write(1 + "\n");
                else bw.write(0 + "\n");
            }
            else if(cmd.equals("top")){
                if(st.empty()) bw.write(-1 + "\n");
                else bw.write(st.peek() + "\n");
            }
        }

        bw.flush();
        bw.close();
    }
}
