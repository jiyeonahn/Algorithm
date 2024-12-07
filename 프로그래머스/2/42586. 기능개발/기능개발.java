import java.util.*;
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < speeds.length; i++){
            q.add((int) Math.ceil((double)(100 - progresses[i]) / speeds[i]));
        }
        //q.add(100);
        
        Queue<Integer> ans = new LinkedList<>();
        int n = q.peek();
        int cnt = 0;
        while(!q.isEmpty()){
            if(q.peek() <= n){
                cnt++;
                q.poll();
            }else{
                ans.add(cnt);
                cnt = 1;
                n = q.poll();
            }
        }
        
        ans.add(cnt);
        
        int[] answer = new int[ans.size()];
        for(int i = 0; i < answer.length; i++){
            answer[i] = ans.poll();
        }
        return answer;
    }
}