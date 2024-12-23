import java.util.*;
class Solution {
    public String solution(String number, int k) {
        StringBuilder sb = new StringBuilder();
        int popCount = 0;
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < number.length(); i++){
            int currentNumber = number.charAt(i) - '0';
            while(!stack.isEmpty() && popCount < k && stack.peek() < currentNumber){
                popCount++;
                stack.pop();
            }
            stack.push(currentNumber);
        }

        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }
        
        String answer = sb.reverse().toString();
        
        if(popCount < k){
            answer = answer.substring(0, number.length() - k);
        }
        
        return answer;
    }

}