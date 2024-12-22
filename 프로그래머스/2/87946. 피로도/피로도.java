class Solution {
    int answer;
    public int solution(int k, int[][] dungeons) {
        for(int i = 0; i < dungeons.length; i++){
            boolean[] visited = new boolean[dungeons.length];
            if(dungeons[i][0] <= k){
                dfs(i, k - dungeons[i][1], dungeons, 1, visited);
            }
        }
        
        return answer;
    }
    public void dfs(int curIndex, int current, int[][] dungeons, int result, boolean[] visited){
        answer = Math.max(answer, result);
        visited[curIndex] = true;
        for(int i = 0; i < dungeons.length; i++){
            if(!visited[i] && dungeons[i][0] <= current){
                dfs(i, current - dungeons[i][1], dungeons, result+1, visited);
            }
            
        }
        visited[curIndex] = false;
    }
}