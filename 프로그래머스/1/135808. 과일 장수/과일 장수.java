import java.util.*;
class Solution {
    public int solution(int k, int m, int[] score) {
        int answer = 0;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b-a);
        
        for(int i = 0; i < score.length; i++){
            pq.add(score[i]);
        }
        
        int cnt = 0;
        while(!pq.isEmpty()){
            int apple = pq.poll();
            cnt++;
            if(cnt == m){
                cnt = 0;
                answer+=m*apple;
            }
        }
        
        return answer;
    }
}