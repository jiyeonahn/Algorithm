import java.util.*;
class Solution {
    public int[] solution(int[] arr) {
        int[] answer;
        ArrayList<Integer> list = new ArrayList<>();
        for(int num : arr)
            list.add(num);

        if(list.size() == 1){
            answer = new int[1];
            answer[0] = -1;
        }

        else{
            int min = Arrays.stream(arr).min().getAsInt();
            for(int i = 0; i < list.size(); i++){
                if(list.get(i) == min)
                    list.remove(i);
            }
            answer = new int[list.size()];
            for(int i = 0; i< answer.length; i++)
                answer[i] = list.get(i);
        }
        return answer;
    }
}