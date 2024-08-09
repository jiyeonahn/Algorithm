import java.util.Arrays;
class Solution {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        char[] ch = s.toCharArray();
        Arrays.sort(ch);
        for(int i = ch.length-1; i >= 0; i--){
            sb.append(ch[i]);
        }
        return sb.toString();
    }
}