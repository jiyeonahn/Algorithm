class Solution
{
    public int solution(int [][]board)
    {
        int[][] map = new int[board.length + 1][board[0].length + 1];
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j <board[0].length; j++){
                map[i+1][j+1] = board[i][j];
            }
        }
        int min = 0;
        int max = 0;
        for(int i = 1; i < map.length; i++){
            for(int j = 1; j < map[0].length; j++){
                if(map[i][j] != 0){
                    map[i][j] = Math.min(map[i][j-1],Math.min(map[i-1][j], map[i-1][j-1])) + 1;
                    max = Math.max(max, map[i][j]);
                }

            }
        }
        return max * max;
    }
}