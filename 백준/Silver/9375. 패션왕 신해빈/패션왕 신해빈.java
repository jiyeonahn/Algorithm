import java.util.*;
import java.io.*;
class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < T; i++){
            int n = Integer.parseInt(br.readLine());
            Map<String, Integer> map = new HashMap<>();
            for(int j = 0; j < n; j++){
                StringTokenizer st = new StringTokenizer(br.readLine());;
                st.nextToken();
                String type = st.nextToken();
                map.put(type, map.getOrDefault(type,0)+1);
            }
            int cnt = 1;
            for(String key : map.keySet()){
                cnt *= (map.get(key)+1);
            }
            sb.append(cnt-1).append("\n");
        }
        System.out.println(sb);
    }
}