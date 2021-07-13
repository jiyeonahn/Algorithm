import java.util.*;
class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        HashMap<String, Integer> hashMap = new HashMap<String, Integer>();

        for(int i = 0; i < clothes.length; i++)
            hashMap.put(clothes[i][1], hashMap.getOrDefault(clothes[i][1], 1) + 1);

        for (String key : hashMap.keySet()){
            answer *= hashMap.get(key);
        }

        return answer - 1;
    }
}