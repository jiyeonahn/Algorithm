import java.util.*;
class Solution {
    public int solution(String s) {
        int answer = 0;
        for(int i = 0; i < s.length(); i++){
            s = s.substring(1) + s.charAt(0);
            Stack<Character> stack = new Stack();
            for(int j = 0; j < s.length(); j++){
                char ch = s.charAt(j);
                if(stack.size() > 0){
                    char prev = stack.peek();
                    if((prev == '(' && ch == ')') || 
                        (prev == '[' && ch == ']') || 
                        (prev == '{' && ch == '}')){
                        stack.pop();
                    }else{
                        stack.push(ch);
                    }
                }else{
                    stack.push(ch);
                }
            }

            if(stack.isEmpty()){
                answer++;
            }
        }
        
        
        return answer;
    }
    
}