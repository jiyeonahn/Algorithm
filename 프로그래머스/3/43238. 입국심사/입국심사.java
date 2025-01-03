import java.util.*;
class Solution {
    public long solution(int n, int[] times) {
        Arrays.sort(times);
        long low = 1;
        long high = (long) times[times.length-1] * n;
        long answer = high;
        
        while(low<=high){
            long mid = (low + high) / 2;
            long total = 0;
            
            for(int time : times){
                total += mid / (long)time;
            }
            
            if(total >= (long)n){
                answer =  mid;
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return answer;
    }
}