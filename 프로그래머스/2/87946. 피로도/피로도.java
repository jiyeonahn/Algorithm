class Solution {
    int answer;
    public int solution(int k, int[][] dungeons) {
        boolean[] visited = new boolean[dungeons.length];
        dfs(k, dungeons, 0, visited);
        
        return answer;
    }
    public void dfs(int current, int[][] dungeons, int result, boolean[] visited){
        answer = Math.max(answer, result);
        for(int i = 0; i < dungeons.length; i++){
            if(!visited[i] && dungeons[i][0] <= current){
                visited[i] = true;
                dfs(current - dungeons[i][1], dungeons, result+1, visited);
                visited[i] = false;
            }
            
        }
    }
}