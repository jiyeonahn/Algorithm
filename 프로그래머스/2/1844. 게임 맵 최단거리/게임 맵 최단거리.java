import java.util.*;
class Solution {
    public int solution(int[][] maps) {
        int answer = -1;
        boolean[][] visited = new boolean[maps.length][maps[0].length];
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};
        
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(0,0));
        
        while(!queue.isEmpty()){
            Node node = queue.poll();
            int n = node.n;
            int m = node.m;
            visited[n][m] = true;
            if(n == maps.length - 1 && m == maps[0].length-1){
                return maps[n][m];
            }
            
            for(int i = 0; i < 4; i++){
                int nx = n + dx[i];
                int my = m + dy[i];
                if(nx >= 0 && my >= 0 && nx < maps.length && my < maps[0].length
                  && !visited[nx][my] && maps[nx][my] == 1){
                    maps[nx][my] = maps[n][m] + 1;
                    queue.add(new Node(nx, my));
                }
            }
        }
        return answer;
    }
    
}
class Node {
    int n;
    int m;
    public Node(int n, int m){
        this.n = n;
        this.m = m;
    }
}