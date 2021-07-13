import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int n : scoville)
            pq.add(n);

        while(pq.peek() < K){
            pq.add(pq.poll() + pq.poll() * 2);
            answer++;
            if(pq.size() == 1 && pq.peek() < K)
                return -1;
        }
        return answer;
    }
}