import java.util.*;
class Solution {
    public int solution(int n, int[][] edge) {
        boolean[][] graph = new boolean[n + 1][n + 1];
        int[] distance = new int[n+1];
        int node = 0;

        for(int i = 0; i < edge.length; i++)
            graph[edge[i][0]][edge[i][1]] = graph[edge[i][1]][edge[i][0]] = true;

        Queue<Integer> queue = new LinkedList<Integer>();
        queue.offer(1);

        while(!queue.isEmpty()){
            node = queue.poll();
            for(int i = 2; i <= n; i++){
                if(distance[i] == 0 && graph[node][i] == true){
                    queue.offer(i);
                    distance[i] = distance[node] + 1;
                }
            }
        }
        int max = 0;
        for(int i = 0; i < distance.length; i++){
            if(distance[i] > max)
                max = distance[i];
        }

        int cnt = 0;
        for(int i : distance){
            if(max == i)
                cnt++;
        }
        return cnt;
    }
}
