import java.util.*;
class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        Queue<Integer> q = new LinkedList();

        for(int i = 0; i < prices.length; i++){
            q.add(prices[i]);
        }

        int index = 0;
        while(!q.isEmpty()){
            int num = q.poll();
            int count = 0;
            for(int i = index + 1; i < prices.length; i++){
                answer[index]++;
                if(num > prices[i])
                    break;
            }
            index++;
        }
        return answer;
    }
}