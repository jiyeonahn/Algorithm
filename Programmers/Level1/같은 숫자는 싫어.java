import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        int preNum = 10;
        for(int num : arr){
            if(preNum != num)
                result.add(num);
            preNum = num;
        }

        int[] answer = new int[result.size()];
        for(int i=0;i<result.size();i++)
            answer[i] = result.get(i);
        return answer;
    }
}