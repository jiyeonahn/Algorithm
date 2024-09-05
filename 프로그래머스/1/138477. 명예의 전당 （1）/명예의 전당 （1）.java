import java.util.PriorityQueue;
class Solution {
    public int[] solution(int k, int[] score) {
        int[] answer = new int[score.length];
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int min = 2000;
        int len = Math.min(k, score.length);
        for(int i = 0; i < len; i++){
            if(min > score[i]){
                min = score[i];
            }
            answer[i] = min;
            pq.add(score[i]);
        }
        
        for(int i = len; i < score.length; i++){
            if(pq.peek() != null){
                if(pq.peek() < score[i]){
                    pq.poll();
                    pq.add(score[i]);
                }
                answer[i] = pq.peek();
            }
        }
        return answer;
    }
}