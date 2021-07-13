import java.util.*;
class Solution {
    //eden kiki leo , eden kiki
    //ana mislav mislav stanko, ana mislav stanko
    public String solution(String[] participant, String[] completion) {
        int idx = 0;
        Arrays.sort(participant);
        Arrays.sort(completion);
        for(int i= 0; i< completion.length; i++){
            if(!completion[i].equals(participant[i])){
                idx = i;
                break;
            }
            idx = participant.length - 1;
        }
        return participant[idx];

    }
}