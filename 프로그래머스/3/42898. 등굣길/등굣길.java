class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int answer = 0;
        int[][] dp = new int[m][n];
        
        dp[0][0] = 1;
        
        int x,y;
        for(int i = 0; i < puddles.length; i++){
            x = puddles[i][0] - 1;
            y = puddles[i][1] - 1;
            dp[x][y] = -1;
        }

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(dp[i][j] == -1) {
                    dp[i][j] = 0;
                    continue;
                }
                if(i != 0){
                    dp[i][j] += dp[i-1][j];
                }
                if(j != 0){
                    dp[i][j] += dp[i][j-1];
                }
                dp[i][j] = dp[i][j] % 1000000007;
            }
        }
        return dp[m-1][n-1];
    }
}