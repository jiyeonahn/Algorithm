import java.util.*;
class Solution {
    boolean[] visited;
    public int solution(int n, int[][] computers) {
        int answer = 0;
        visited = new boolean[n];
        
        for(int i = 0; i < n; i++){
            if(computers[i][i] == 1 && !visited[i]){
                answer++;
                bfs(i, n, computers);
            }
        }
        
        return answer;
    }
    
    void bfs(int x, int n, int[][] computers){
        visited[x] = true;
        
        Queue<Integer> q = new LinkedList<>();
        q.add(x);
        while(!q.isEmpty()){
            int target = q.poll();
            for(int i = 0; i < n; i++){
                if(!visited[i] && computers[i][target] == 1){
                    visited[i] = true;
                    q.add(i);
                }
            }
        }
        
    }
}