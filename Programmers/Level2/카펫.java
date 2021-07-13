import java.lang.Math;
class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int sum = brown + yellow;
        int start = (int)Math.sqrt(sum);
        for(int i = start; i < sum; i++){
            if(sum % i == 0){
                answer[0] = Math.max(i, sum / i);
                answer[1] = Math.min(i, sum / i);
                if((answer[0] - 2) * (answer[1] - 2) == yellow)
                    break;
            }
        }
        return answer;
    }
}