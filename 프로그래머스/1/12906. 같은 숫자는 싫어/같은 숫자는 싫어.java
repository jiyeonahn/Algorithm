import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        Queue<Integer> queue = new LinkedList<>();
        int num = -1;
        for(int i = 0; i < arr.length; i++){
            if(num != arr[i]){
                queue.add(arr[i]);
            }
            num = arr[i];
        }
        int[] answer = new int[queue.size()];
        
        int idx = 0;
        while(!queue.isEmpty()){
            answer[idx++] = queue.poll();
        }

        return answer;
    }
}