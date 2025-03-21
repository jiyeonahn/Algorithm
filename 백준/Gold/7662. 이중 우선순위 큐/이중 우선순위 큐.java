import java.util.*;
import java.io.*;
class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < T; i++){
            TreeMap<Integer, Integer> treeMap = new TreeMap<>();
            int k = Integer.parseInt(br.readLine());
            for(int j = 0; j < k; j++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                String command = st.nextToken();
                int n = Integer.parseInt(st.nextToken());
                if("I".equals(command)){
                    treeMap.put(n, treeMap.getOrDefault(n,0)+1);
                }
                if("D".equals(command)){
                    if(treeMap.isEmpty()) continue;
                    int key = 0;
                    if(n == 1){//최대값
                        key = treeMap.lastKey();
                    }
                    if(n == -1){//최솟값
                        key = treeMap.firstKey();
                    }
                    if(treeMap.get(key) == 1){
                        treeMap.remove(key);
                    }else{
                        treeMap.put(key, treeMap.get(key)-1);
                    }
                }
            }
            if(treeMap.isEmpty()){
                sb.append("EMPTY");
            }else{
                sb.append(treeMap.lastKey()).append(" ").append(treeMap.firstKey());
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}