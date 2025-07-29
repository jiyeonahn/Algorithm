import java.util.*;
import java.io.*;
class Main{
    public static void main(String[] args) throws IOException {
        int answer = 0;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        String target = br.readLine();

        Map<Character, Integer> map = new HashMap<>();

        for(int i = 0; i < target.length(); i++){
            map.put(target.charAt(i), map.getOrDefault(target.charAt(i), 0) + 1);
        }

        for(int i = 0; i < n-1; i++){
            int cnt = 0;

            Map<Character, Integer> map2 = new HashMap<>();

            String word = br.readLine();

            Set<Character> set = new HashSet<>(map.keySet());

            for(int j = 0; j < word.length(); j++){
                map2.put(word.charAt(j), map2.getOrDefault(word.charAt(j), 0) + 1);
            }

            set.addAll(map2.keySet());

            for(char ch : set){
                cnt += Math.abs(map2.getOrDefault(ch, 0) - map.getOrDefault(ch, 0));
            }

            if(cnt == 0 || cnt == 1 || cnt == 2 && target.length() == word.length()){
                answer++;
            }
        }
        System.out.println(answer);
    }
}