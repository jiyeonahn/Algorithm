import java.io.*;
import java.util.*;
class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        HashMap<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < str.length(); i++){
            map.put(str.charAt(i), map.getOrDefault(str.charAt(i), 0)+1);
        }

        boolean possible = false;
        if(map.getOrDefault('M',0) > 0
                && map.getOrDefault('O',0) > 0
                && map.getOrDefault('B',0) > 0
                && map.getOrDefault('I',0) > 0
                && map.getOrDefault('S',0) > 0){
            possible = true;
        }

        System.out.println(possible ? "YES" : "NO");
    }
}