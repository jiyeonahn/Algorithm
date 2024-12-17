import java.util.*;
class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> {
            return b-a;
        });
        Queue<Node> queue = new LinkedList<>();
        for(int i = 0; i < priorities.length; i++){
            pq.add(priorities[i]);
            queue.add(new Node(priorities[i], i));
        }
        
        while(!queue.isEmpty()){
            int ql = queue.peek().location;
            int qp = queue.peek().priority;
            
            if(pq.peek() == qp){
                pq.poll();
                queue.poll();
                answer++;
            }else{
                queue.add(queue.poll());
                continue;
            }
            
            if(ql == location){
                return answer;
            }
        }
        
        return answer;
    }
}
class Node {
    int priority;
    int location;
    
    public Node(int priority, int location){
        this.priority = priority;
        this.location = location;
    }
}