import java.util.*;

public class Solution {
    public int solution(int n) {
        int ans = 0;
        int num = n;
        while(num>0){
            if(num%2 == 1){
                num--;
                ans++;
            }else{
                num/=2;
            }
        }
        
        return ans;
    }
}