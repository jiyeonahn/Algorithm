import java.util.*;
class Solution {
    boolean solution(String s) {
        boolean answer = true;
        Stack<String> stack = new Stack<>();
        for(int i = 0; i < s.length(); i++) {
            stack.push(s.substring(i, i+1));
            if(stack.peek().equals(")")){
                stack.pop();
                if(stack.isEmpty()){
                    return false;
                }
                if(!stack.pop().equals("(")){
                    return false;
                }
            }
        }
        if(!stack.isEmpty()) return false;
        return answer;
    }
}