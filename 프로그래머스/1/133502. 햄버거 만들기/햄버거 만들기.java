import java.util.*;
class Solution {
    public int solution(int[] ingredient) {
        int answer = 0;
        
        Stack<Integer> stack = new Stack();
        //1-2-3-1
        for(int i = 0; i < ingredient.length; i++){
            if(ingredient[i] == 1 && stack.size() >= 3){
                int first = stack.pop();
                int second = stack.pop();
                int third = stack.pop();
                
                if(first == 3 && second == 2 && third == 1){
                    answer++;
                    continue;
                }
                stack.add(third);
                stack.add(second);
                stack.add(first);
            }
            stack.add(ingredient[i]);
        }
        
        return answer;
    }
}