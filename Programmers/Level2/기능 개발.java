import java.util.*;
import java.lang.Math;
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> q = new LinkedList<>();
        ArrayList<Integer> result = new ArrayList<>();

        for(int i = 0; i < speeds.length; i++)
            q.add((int)Math.ceil((100 - progresses[i]) / (double)speeds[i]));

        while(!q.isEmpty()){
            int count = 1;
            int num = q.poll();//5
            while(q.peek() != null){
                if(num >= q.peek()){
                    q.poll();
                    count++;
                }
                else break;
            }
            result.add(count);

        }
        int[] answer = new int[result.size()];
        for(int j = 0; j < result.size(); j++){
            answer[j] = result.get(j);
        }
        return answer;
    }
}