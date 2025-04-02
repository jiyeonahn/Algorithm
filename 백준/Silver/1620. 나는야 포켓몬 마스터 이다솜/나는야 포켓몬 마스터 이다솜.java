import java.util.*;
import java.io.*;
class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        HashMap<Integer, String> map = new HashMap<>();
        HashMap<String, Integer> map2 = new HashMap<>();

        for(int i = 1; i <= N; i++){
            String name = br.readLine();
            map.put(i, name);
            map2.put(name, i);
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < M; i++){
            String cmd = br.readLine();
            if(map2.get(cmd) == null){
                sb.append(map.get(Integer.parseInt(cmd)));
            }else{
                sb.append(map2.get(cmd));
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }
}