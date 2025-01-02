//12:45
import java.util.*;
class Solution {
    String[] answer;
    boolean[] visited;
    boolean found;
    public String[] solution(String[][] tickets) {
        answer = new String[tickets.length+1];
        visited = new boolean[tickets.length];
        Arrays.sort(tickets, (o1, o2) -> {
            if(o1[0].equals(o2[0])){
                return o1[1].compareTo(o2[1]);
            }
            return o1[0].compareTo(o2[1]);
        });

        
        dfs(0, "ICN", tickets);
        return answer;
    }
    public void dfs(int index, String arrived, String[][] tickets){
        if(index == tickets.length){
            answer[index] = arrived;
            found = true;
            return;
        }
        answer[index] = arrived;
        for(int i = 0; i < tickets.length; i++){
            if(!visited[i] && tickets[i][0].equals(arrived)){
                visited[i] = true;
                dfs(index + 1, tickets[i][1], tickets);
                if(found) return;
                visited[i] = false;
            }
        }
    }
}