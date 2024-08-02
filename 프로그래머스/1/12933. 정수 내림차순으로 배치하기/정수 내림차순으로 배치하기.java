import java.util.Arrays;
import java.util.Collections;

class Solution {
    public long solution(long n) {
        long answer = 0;
        char[] arr = (n+"").toCharArray();
        Arrays.sort(arr);
        
        return Long.valueOf(new StringBuilder(new String(arr)).reverse().toString());
    }
}