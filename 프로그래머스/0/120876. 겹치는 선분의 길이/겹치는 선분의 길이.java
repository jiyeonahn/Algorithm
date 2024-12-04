import java.util.*;
class Solution {
    public int solution(int[][] lines) {
        int answer = 0;
        int[] arrays = new int[201];
        int startIdx = 0;
        int endIdx = 0;
        for(int i = 0; i < 3; i++){
            startIdx = 100+lines[i][0];
            endIdx = 100+lines[i][1];
            for(int j = startIdx; j < endIdx; j++){
                arrays[j]++;
            }
        }
        for(int i = 0; i <= 200; i++){
            if(arrays[i] > 1){
                answer++;
            }
        }
        return answer;
    }
}