import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        Queue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for(int n : priorities)
            pq.offer(n);
        // 1 1 9 1 1 1 priorities location = 0
        // 9 1 1 1 1 1 pq
        while(!pq.isEmpty()){
            for(int i = 0; i < priorities.length; i++){
                if(pq.peek() == priorities[i]){
                    answer++;
                    pq.poll();
                    if(location == i)
                        return answer;
                }
            }
        }
        return answer;
    }
}