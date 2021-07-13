import java.util.*;
class Solution {
    public String solution(String s) {
        char[] alpha = s.toCharArray();
        Arrays.sort(alpha);
        StringBuilder sb = new StringBuilder(String.valueOf(alpha));
        sb.reverse();

        return sb.toString();
    }
}