class Solution {
    public int solution(String[][] board, int h, int w) {
        int answer = 0;
        int[] dx = {0,1,0,-1};
        int[] dy = {1,0,-1,0};
        
        for(int i = 0 ; i < 4; i++){
            int nx = h + dx[i];
            int ny = w + dy[i];
            
            if(nx >= 0 && nx < board.length && ny >= 0 && ny < board[0].length){
                if(board[nx][ny].equals(board[h][w])){
                    answer++;
                }
            }
        }
        return answer;
    }
}