import java.util.*;
class Solution {
    public String solution(String[] participant, String[] completion) {
        HashMap<String, Integer> hashMap = new HashMap<>();
        for(String person : participant){
            hashMap.put(person, hashMap.getOrDefault(person, 0) + 1);
        }
        
        for(String person : completion){
            hashMap.put(person, hashMap.get(person) - 1);
        }
        
        for(String key : hashMap.keySet()){
            if(hashMap.get(key) > 0){
                return key;
            }
        }
        return "";
    }
}