import java.util.*;
class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        int[] answer = new int[photo.length];
        Map<String, Integer> map = new HashMap<>();
        
        for(int i = 0; i < name.length; i++){
            map.put(name[i], yearning[i]);
        }
        
        for(int i = 0; i < photo.length; i++){
            int total = 0;
            for(int j = 0; j < photo[i].length; j++){
                String person = photo[i][j];
                total += map.getOrDefault(person, 0);
            }
            answer[i] = total;
        }
        
        return answer;
    }
}