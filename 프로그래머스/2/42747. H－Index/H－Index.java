import java.util.*;
class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        Arrays.sort(citations);
        for(int i = 1; i < citations[citations.length-1]; i++){
            for(int j = 0; j < citations.length; j++){
                if(citations[j] >= i){//h번 이상 인용된 논문이 
                    if(j <= i && citations.length - j >= i){
                        answer = i;
                    }
                }
            }
        }
        return answer;
    }
}