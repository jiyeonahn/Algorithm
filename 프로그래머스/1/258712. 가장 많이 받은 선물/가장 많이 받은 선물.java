import java.util.*; 
class Solution {
    public int solution(String[] friends, String[] gifts) {
        int answer = 0;
        
        int[][] fd = new int[friends.length][friends.length];
        
        HashMap<String, Integer> map = new HashMap<>();
        
        for(int i = 0; i < friends.length; i++){
            map.put(friends[i], i);
        }
        
        for(int i = 0; i < gifts.length; i++){
            String[] gift = gifts[i].split(" ");
            
            int A = map.get(gift[0]);
            int B = map.get(gift[1]);
            
            fd[A][B]++;
        }
        
        //선물지수
        int[] level = new int[friends.length];
        for(int i = 0; i < friends.length; i++){
            int give = 0;
            int receive = 0;
            for(int j = 0; j < friends.length; j++){
                give += fd[i][j];
                receive += fd[j][i];
            }
            level[i] = give - receive;
        }
        
        int[] nextMonthReceive = new int[friends.length];
        
        //다음달
        for(int i = 0; i < friends.length; i++){
            for(int j = 0; j < friends.length; j++){
                if(i == j) continue;
                if(fd[i][j] > fd[j][i]) {
                    nextMonthReceive[i]++;
                }else if(fd[i][j] < fd[j][i]){
                    nextMonthReceive[j]++;
                }else{
                    if(level[i] > level[j]){
                        nextMonthReceive[i]++;
                    }else if(level[i] < level[j]){
                        nextMonthReceive[j]++;
                    }
                }
            }
            System.out.println();
        }
        
        for(int i = 0; i < friends.length; i++){
            answer = Math.max(answer, nextMonthReceive[i]);
        }
        
        return answer/2;
    }
}