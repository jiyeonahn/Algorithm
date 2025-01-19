import java.util.*;
import java.io.*;
class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        HashMap<Long, Integer> hashMap = new HashMap<>();
        for(int i = 0; i < N; i++){
            Long num = Long.parseLong(br.readLine());
            hashMap.put(num, hashMap.getOrDefault(num, 0) + 1);
        }

        int max = 0;
        Long result = 0L;
        for(Long key : hashMap.keySet()){
            int value = hashMap.get(key);
            if(value > max) {
                max = value;
                result = key;
            }else if(value == max){
                result = Math.min(result, key);
            }
        }
        System.out.println(result);
    }
}