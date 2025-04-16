import java.util.*;
class Solution {
    public String solution(String s) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        boolean prevEmpty = true;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == ' '){
                prevEmpty = true;
                sb.append(s.charAt(i));
                continue;
            }
            if(!prevEmpty){
                if(s.charAt(i) >= 'A' && s.charAt(i) <= 'Z'){
                    sb.append((char)(s.charAt(i)+32));
                    continue;
                }
            }
            if(prevEmpty){
                prevEmpty = false;
                if(s.charAt(i) >= 'a' && s.charAt(i) <= 'z'){
                    sb.append((char)(s.charAt(i)-32));
                    continue;
                }
            }
            
            sb.append(s.charAt(i));
            
        }
        return sb.toString();
    }
}