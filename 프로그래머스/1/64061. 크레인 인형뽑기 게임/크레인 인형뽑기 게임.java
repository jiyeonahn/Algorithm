import java.util.*;
class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        
        Stack<Integer> stack = new Stack<>();
        
        for(int i = 0; i < moves.length; i++){
            for(int j = 0; j < board.length; j++){
                int doll = board[j][moves[i]-1];
                
                if(doll != 0){                    
                    board[j][moves[i]-1] = 0;
                    if(stack.size() > 0 && stack.peek() == doll){
                        stack.pop();
                        answer++;
                        break;
                    }
                    stack.add(doll);
                    break;
                }
            }
        }
        return answer*2;
    }
}