class Solution {
    public int[] solution(String[] keyinput, int[] board) {
        int[] answer = {0,0};
        for(String direction : keyinput){
            if("up".equals(direction)){
                if(answer[1] < board[1]/2){
                    answer[1]++;
                }
            }else if("down".equals(direction)){
                if(answer[1] > -board[1]/2){
                    answer[1]--;
                }
            }else if("left".equals(direction)){
                if(answer[0] > -board[0]/2){
                    answer[0]--;
                }
            }else if("right".equals(direction)){
                if(answer[0] < board[0]/2){
                    answer[0]++;
                }
            }
        }
        
        return answer;
    }
}