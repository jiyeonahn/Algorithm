import java.util.*;
class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        HashMap<String, Integer> hashMap = new HashMap<>();
        for(String person : participant){
            hashMap.put(person, hashMap.get(person) == null ? 1 : hashMap.get(person) + 1);
        }
        
        for(String person : completion){
            hashMap.put(person, hashMap.get(person) - 1);
        }
        
        for(String key : hashMap.keySet()){
            if(hashMap.get(key) > 0){
                answer = key;
                break;
            }
        }
        return answer;
    }
}