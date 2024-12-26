import java.util.*;
class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        Arrays.sort(people);
        int lastIndex = people.length-1;
        int startIndex = 0;
        
        while(startIndex <= lastIndex){
            if(people[lastIndex] + people[startIndex] <= limit){
                startIndex++;
            }
            lastIndex--;
            answer++;
        }
        
        return answer;
    }
}