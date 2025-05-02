import java.io.*;
import java.util.*;
class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str1 = br.readLine();
        String str2 = br.readLine();

        HashMap<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < str1.length(); i++){
            char ch = str1.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        int count = 0;
        for(int i = 0; i < str2.length(); i++){
            char ch = str2.charAt(i);
            if(map.getOrDefault(ch,0) == 0){
                count++;
            }else{
                map.put(ch, map.get(ch)-1);
            }
        }

        for(char key : map.keySet()){
            count += map.get(key);
        }

        System.out.println(count);
    }
}