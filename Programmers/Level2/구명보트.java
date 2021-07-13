import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = people.length;
        Arrays.sort(people);
        int i = 0;
        int j = people.length - 1;

        while(i < j){
            int sum = people[i] + people[j];
            if(sum <= limit){
                answer--;
                i++;
            }
            --j;
        }
        return answer;
    }
}