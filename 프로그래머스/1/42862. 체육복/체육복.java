import java.util.*;
class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        Arrays.sort(lost);
        Arrays.sort(reserve);
        
        int answer = n - lost.length;
        int idx = 0;
        for(int i = 0; i < reserve.length; i++){
            for(int j = 0; j < lost.length; j++){
                if(reserve[i] == lost[j]){
                    reserve[i] = -1;
                    lost[j] = -1;
                    answer++;
                }
            }
        }
        for(int i = 0; i < reserve.length; i++){
            if(reserve[i] == -1) continue;
            for(int j = 0; j < lost.length; j++){
                if(lost[j] == -1) continue;
                if(reserve[i] + 1 == lost[j] || reserve[i] - 1 == lost[j]){
                    lost[j] = -1;   
                    reserve[i] = -1;
                    answer++;
                }
            }
        }
        return answer;
    }
}