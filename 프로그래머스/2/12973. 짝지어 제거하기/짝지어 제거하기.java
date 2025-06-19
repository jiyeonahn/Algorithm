import java.util.*;
class Solution
{
    public int solution(String s)
    {
        int answer = -1;
        
        Stack<Character> stack = new Stack<>();
        
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            boolean b = false;
            while(!stack.isEmpty()){
                if(ch == stack.peek()){
                    b = true;
                    stack.pop();
                }else{
                    break;
                }
            }
            if(!b){
                stack.add(ch);
            }
        }
        
        System.out.println(stack.size());
        return stack.size() == 0 ? 1 : 0;
    }
}