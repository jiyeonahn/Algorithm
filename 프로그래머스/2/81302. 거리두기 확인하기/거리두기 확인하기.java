import java.util.Queue;
import java.util.LinkedList;
class Solution {
    public int[] solution(String[][] places) {
        int[] answer = {1,1,1,1,1};
        
        for(int i = 0; i < 5; i++){
            for(int j = 0; j < 5; j++){
                for(int k = 0; k < 5; k++){
                    if(places[i][j].charAt(k) == 'P'){
                        if(!checkSeat(j,k,places[i])){
                            answer[i] = 0;
                        }
                    }
                }
            }
        }
        
        return answer;
    }
    
    public boolean checkSeat(int x, int y, String[] seat){
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};
        
        Queue<Node> q = new LinkedList<Node>();
        boolean[][] visited = new boolean[5][5];
        visited[x][y] = true;
        
        q.offer(new Node(x,y));
        
        while(!q.isEmpty()) {
			Node current = q.poll();
            
            for(int i = 0; i < 4; i++){
                int nx = current.x + dx[i];
                int ny = current.y + dy[i];
                int manhattean = Math.abs(x-nx) + Math.abs(y-ny);
                
                if(nx < 0 || ny < 0 || nx >= 5 || ny >= 5) continue;
                if(visited[nx][ny] || manhattean > 2) continue;
                
                visited[nx][ny] = true;
                if(seat[nx].charAt(ny) == 'X'){
                    continue;
                }
                if(seat[nx].charAt(ny) == 'P'){
                    return false;
                }
                if(seat[nx].charAt(ny) == 'O'){
                    q.offer(new Node(nx, ny));
                }
                
            }
			
		}
        return true;
    }
    
    public class Node{
        int x;
        int y;
        
        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}