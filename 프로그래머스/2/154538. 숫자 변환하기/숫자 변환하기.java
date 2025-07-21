import java.util.*;
class Solution {
    public int solution(int x, int y, int n) {
        int answer = -1;
        
        Queue<int[]> queue = new LinkedList<>();
        
        queue.add(new int[]{x,0});
        
        boolean[] visited = new boolean[y+1];
        
        while(!queue.isEmpty()){
            int[] now = queue.poll();
            int num = now[0];
            int count = now[1];
            
            if(num == y){
                answer = count;
                break;
            }
            
            if(num+n <= y && !visited[num+n]){
                visited[num+n] = true;
                queue.add(new int[]{num+n, count+1});
            }
            if(num*2 <= y && !visited[num*2]){
                visited[num*2] = true;
                queue.add(new int[]{num*2, count+1});
            }
            if(num*3 <= y && !visited[num*3]){
                visited[num*3] = true;
                queue.add(new int[]{num*3, count+1});
            }
            
        }
        return answer;
    }
}