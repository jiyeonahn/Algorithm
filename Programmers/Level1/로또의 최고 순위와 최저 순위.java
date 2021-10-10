import java.util.*;

class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        int zeroCnt = 0;
        int sameCnt = 0;
        Arrays.sort(lottos);
        Arrays.sort(win_nums);

        for(int i = 0; i < 6; i++){
            if(lottos[i] == 0) {
                zeroCnt++;
                continue;
            }
            for(int j = 0; j < 6; j++){
                if(lottos[i] < win_nums[j]) break;
                else if(lottos[i] == win_nums[j]) sameCnt++;
            }
        }
        if(sameCnt + zeroCnt == 0) answer[0] = 6;
        else answer[0] = 6 - (sameCnt + zeroCnt) + 1;

        if(sameCnt == 0) answer[1] = 6;
        else answer[1] = 6 - sameCnt + 1;

        return answer;
    }
}