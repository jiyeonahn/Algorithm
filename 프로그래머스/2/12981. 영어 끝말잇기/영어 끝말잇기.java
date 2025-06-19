import java.util.*;
class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];
        HashSet<String> set = new HashSet<>();
        set.add(words[0]);
        char lastAlpha = words[0].charAt(words[0].length()-1);
        for(int i = 1; i < words.length; i++){
            if(set.contains(words[i]) || lastAlpha != words[i].charAt(0)){
                answer[0] = i%n+1;
                answer[1] = (int)Math.ceil((i+1)/(double)n);
                break;
            }
            set.add(words[i]);
            lastAlpha = words[i].charAt(words[i].length()-1);
        }

        return answer;
    }
}