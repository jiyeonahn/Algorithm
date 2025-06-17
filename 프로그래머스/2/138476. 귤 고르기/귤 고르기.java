import java.util.*;
class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int t : tangerine){
            map.put(t, map.getOrDefault(t, 0) + 1);
        }
        
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b-a);
        
        for(int key : map.keySet()){
            pq.offer(map.get(key));
        }
        
        int sum = 0;
        while(!pq.isEmpty()){
            answer++;
            sum += pq.poll();
            if(sum >= k){
                break;
            }
        }
        
        return answer;
    }
}