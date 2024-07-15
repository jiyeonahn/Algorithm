class Solution {
    public int solution(int[][] board) {
        int answer = 0;
        
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(board[i][j] == 0){
                    if(checkSafe(i,j,board)){
                        answer++;
                    }
                }
            }
        }
        
        return answer;
    }
    public boolean checkSafe(int x, int y, int[][] board){
        for(int i = -1; i < 2; i++){
            for(int j = -1; j < 2; j++){
                try{
                    if(board[x+i][y+j] == 1){
                        return false;
                    }
                }catch(ArrayIndexOutOfBoundsException e){
                    continue;
                }
            }
        }
        return true;
    }
}