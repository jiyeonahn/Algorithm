import java.util.*;

class Solution {
    public int[] solution(int[] arr, int divisor) {
        int count = 0;
        ArrayList<Integer> result = new ArrayList<Integer>();
        for(int i = 0; i < arr.length; i++){
            if(arr[i] % divisor == 0){
                result.add(arr[i]);
                count++;
            }
        }

        if(count == 0)
            result.add(-1);

        Collections.sort(result);

        int[] answer = new int[result.size()];
        for(int i=0;i<answer.length; i++)
            answer[i] = result.get(i);
        return answer;
    }
}