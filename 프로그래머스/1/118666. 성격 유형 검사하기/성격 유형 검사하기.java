import java.util.*;
class Solution {
    public String solution(String[] survey, int[] choices) {
        String answer = "";
        
        HashMap<Character, Integer> map = new HashMap<>();
        
        for(int i = 0; i < survey.length; i++){
            char agree = survey[i].charAt(0);
            char disagree = survey[i].charAt(1);
            
            if(choices[i] < 4){
                map.put(agree, map.getOrDefault(agree, 0) + 4-choices[i]);
            }
            if(choices[i] > 4){
                map.put(disagree, map.getOrDefault(disagree, 0) + choices[i]-4);
            }
        }
        
        char[] ch = new char[]{'R','C','J','A'};
        char[] ch2 = new char[]{'T','F','M','N'};
        
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0; i < 4; i++){
            if(map.getOrDefault(ch[i], 0) < map.getOrDefault(ch2[i], 0)){
                sb.append(ch2[i]);
            }else if(map.getOrDefault(ch[i], 0) > map.getOrDefault(ch2[i], 0)){
                sb.append(ch[i]);
            }else{
                sb.append(ch[i]);
            }
        }
        
        return sb.toString();
    }
}