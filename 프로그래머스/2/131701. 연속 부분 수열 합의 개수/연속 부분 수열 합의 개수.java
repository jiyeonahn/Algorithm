import java.util.*;
class Solution {
    public int solution(int[] elements) {
        int answer = 0;
        
        HashSet<Integer> set = new HashSet<>();
        
        for(int i = 1; i <= elements.length; i++){
            for(int j = 0; j < elements.length; j++){
                int sum = 0;
                int cnt = 0;
                int idx = j;
                while(cnt < i){
                    if(idx == elements.length){
                        idx = 0;
                    }
                    sum += elements[idx++];
                    cnt++;
                }
                set.add(sum);
            }
        }
        
        return set.size();
    }
}