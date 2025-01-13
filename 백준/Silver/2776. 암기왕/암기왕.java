import java.util.*;
import java.io.*;
class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < T; i++){
            int N = Integer.parseInt(br.readLine());
            HashSet<Integer> set = new HashSet<>();
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < N; j++){
                set.add(Integer.parseInt(st.nextToken()));
            }
            int M = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < M; j++){
                if(set.contains(Integer.parseInt(st.nextToken()))){
                    sb.append("1").append("\n");
                }else{
                    sb.append("0").append("\n");
                }
            }
        }
        System.out.println(sb.toString());
    }
}