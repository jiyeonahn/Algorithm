import java.util.Arrays;
class Solution {
    public int solution(int[] numbers) {
        int answer = 0;
        StringBuilder sb = new StringBuilder();
        for(int n : numbers){
            sb.append(n);
        }
        String numStr = sb.toString();
        
        for(int i = 1; i < 10; i++){
            if(!numStr.contains(String.valueOf(i))) answer += i;
        }
        
        return answer;
    }
}