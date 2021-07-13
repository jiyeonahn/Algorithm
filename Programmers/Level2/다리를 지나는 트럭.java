import java.util.*;
class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        int sum = 0;
        Queue<Integer> q = new LinkedList<Integer>();
        for(int t : truck_weights){
            while(true){
                if(q.isEmpty()){
                    q.add(t);
                    answer++;
                    sum += t;
                    break;
                } else if(q.size() == bridge_length){
                    sum -= q.poll();
                } else{
                    if(sum + t > weight){
                        answer++;
                        q.add(0);
                    }else{
                        answer++;
                        q.add(t);
                        sum += t;
                        break;
                    }
                }
            }
        }
        return answer + bridge_length;
    }
}