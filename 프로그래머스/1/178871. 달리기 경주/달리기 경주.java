import java.util.*;
class Solution {
    public String[] solution(String[] players, String[] callings) {
        String[] answer = new String[players.length];
        
        HashMap<String, Integer> map = new HashMap<>();
        
        for(int i = 0; i < players.length; i++){
            answer[i] = players[i];
            map.put(answer[i], i);
        }
        
        for(int i = 0; i < callings.length; i++){
            int rank = map.get(callings[i]);
            
            String player = answer[rank-1];
            answer[rank-1] = callings[i];
            answer[rank] = player;
            
            map.put(callings[i], rank-1);
            map.put(player, rank);
        }
        
        return answer;
    }
}