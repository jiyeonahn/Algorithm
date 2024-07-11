import java.util.HashSet;
import java.util.Set;
import java.util.Arrays;
class Solution {
    public int[] solution(int n) {
        int num = 2;
        Set<Integer> set = new HashSet<Integer>();
        
        while(n>1){
            if(n%num == 0){
                n = n/num;
                set.add(num);
            }else{
                num++;
            }
        }
        
        int[] answer = new int[set.size()];
        int idx = 0;
        for(int ns : set){
            answer[idx++] = ns;
        }
        Arrays.sort(answer);
        
        return answer;
    }
}