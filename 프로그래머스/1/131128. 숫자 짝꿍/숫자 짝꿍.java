import java.util.*;
class Solution {
    public String solution(String X, String Y) {
        String answer = "";
        
        HashMap<Integer, Integer> map = new HashMap<>();
        
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> Integer.compare(b,a));
        
        for(int i = 0; i < X.length(); i++){
            int n = X.charAt(i) - '0';
            map.put(n, map.getOrDefault(n,0)+1);
        }
        
        for(int i = 0; i < Y.length(); i++){
            int n = Y.charAt(i) - '0';
            if(map.get(n) != null && map.get(n) > 0){
                map.put(n, map.get(n)-1);
                pq.offer(n);
            }
        }
        
        StringBuilder sb = new StringBuilder();
        while(!pq.isEmpty()){
            sb.append(pq.poll());
        }
        
        answer = sb.toString();
        
        if(answer.startsWith("0")){
            answer = "0";
        }
        
        return answer.isEmpty() ? "-1" : answer;
    }
}