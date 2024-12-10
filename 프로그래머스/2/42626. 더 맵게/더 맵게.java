import java.util.*;
class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int n : scoville){
            pq.add(n);
        }
        int mixScoville = 0;
        while(pq.size() > 1 && pq.peek() < K){
            answer++;
            mixScoville = pq.poll() + pq.poll() * 2;
            pq.add(mixScoville);
            if(pq.peek() >= K){
                return answer;
            }
        }
        return answer == 0 ? 0 : -1;
    }
}