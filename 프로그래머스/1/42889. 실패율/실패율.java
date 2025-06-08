import java.util.*;
class Solution {
    public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        Arrays.sort(stages);

        PriorityQueue<Node> pq = new PriorityQueue<>((a,b) -> {
            if(a.fail == b.fail){
                return Integer.compare(a.idx, b.idx);
            }
            return Double.compare(b.fail, a.fail);
        });

        int challenge = 0;
        int fail = 0;
        int stage = 1;
        while(stage <= N){
            for(int i = 0; i < stages.length; i++){
                if(stage <= stages[i]){
                    challenge++;//스테이지 도전자
                    if(stage == stages[i]){
                        fail++;//클리어하지 못한 사람
                    }
                }
            }
            
            double failureRate = (double)fail/challenge;
            if(challenge == 0){
                failureRate = 0;
            }
            pq.offer(new Node(stage, failureRate));
            challenge = 0;
            fail = 0;
            stage++;
        }

        int i = 0;
        while (!pq.isEmpty()) {
            answer[i++] = pq.poll().idx;
        }
        
        return answer;
    }
}
class Node{
    int idx;
    double fail;

    public Node(int idx, double fail) {
        this.idx = idx;
        this.fail = fail;
    }
}