import java.util.*;
class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        
        HashMap<String, Integer> map = new HashMap<>();
        HashMap<String, Integer> map2 = new HashMap<>();
        
        for(int i = 0; i < 10; i++){
            map.put(discount[i], map.getOrDefault(discount[i], 0) + 1);
        }
        
        for(int i = 0; i < number.length; i++){
            map2.put(want[i], number[i]);
        }
        
        int cnt = 0;
        for(int i = 0; i < want.length; i++){
            if(map.getOrDefault(want[i], 0) == map2.get(want[i])){
                cnt++;
            }
        }
        
        if(cnt == want.length){
            answer++;
        }
        
        for(int i = 0; i < discount.length - 10; i++){
            cnt = 0;
            
            map.put(discount[i], map.getOrDefault(discount[i], 1) - 1);
            map.put(discount[10+i], map.getOrDefault(discount[10+i], 0) + 1);
            
            for(int j = 0; j < want.length; j++){
                if(map.getOrDefault(want[j], 0) == map2.get(want[j])){
                        cnt++;
                    }
            }

            if(cnt == want.length){
                answer++;
            }
        }
        
        return answer;
    }
}