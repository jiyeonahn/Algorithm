import java.sql.Array;
import java.util.*;
import java.io.*;
class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        HashMap<String, Integer> map = new HashMap<>();

        for(int i = 0; i < N; i++){
            String name = br.readLine();
            map.put(name, map.getOrDefault(name, 0) + 1);
        }

        for(int i = 0; i < M; i++){
            String name = br.readLine();
            map.put(name, map.getOrDefault(name, 0) + 1);
        }

        int count = 0;
        StringBuilder sb = new StringBuilder();
        ArrayList<String> nameList = new ArrayList<>();

        for(String key : map.keySet()){
            if(map.get(key) == 2){
                count++;
                nameList.add(key);
            }
        }

        Collections.sort(nameList);

        sb.append(count).append("\n");
        for(String name: nameList){
            sb.append(name).append("\n");
        }

        System.out.println(sb);
    }
}