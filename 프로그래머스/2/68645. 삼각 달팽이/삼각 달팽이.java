class Solution {
    public int[] solution(int n) {
        int[] answer = new int[n*(n+1)/2];
        int[][] array = new int[n][n];
        
        int cnt = 0;
        int x = -1;
        int y = 0;
        
        for(int i = 0; i < n; i++){
            for(int j = i; j < n; j++){
                if(i%3 == 0){
                    x++;
                }
                if(i%3 == 1){
                    y++;
                }
                if(i%3 == 2){
                    x--;
                    y--;
                }
                array[x][y] = ++cnt;
            }
        }
        
        int idx = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(array[i][j] == 0) break;
                answer[idx++] = array[i][j];
            }
        }
        return answer;
    }
}