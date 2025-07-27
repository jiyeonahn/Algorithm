import java.util.*;
class Solution {
    public int solution(int[] order) {
        int answer = 0;
        int n = 1;
        int i = 0;
        Stack<Integer> stack = new Stack();
        
        while(i < order.length){
            if(order[i] == n){
                answer++;
                i++;
            }else if(!stack.isEmpty() && stack.peek() == order[i]){
                answer++;
                i++;
                stack.pop();
                continue;
            }else{
                if(n == order.length+1) break;
                stack.push(n);
            }
            n++;
        }
        return answer;
    }
}