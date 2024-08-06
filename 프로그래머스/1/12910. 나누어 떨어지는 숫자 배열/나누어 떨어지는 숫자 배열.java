import java.util.Arrays;
class Solution {
    public int[] solution(int[] arr, int divisor) {
        int[] answer = {};
        int count = 0;
        for(int num : arr){
            if(num % divisor == 0){
                count++;
            }
        }
        if(count == 0) {
            return new int[] {-1};
        }
        answer = new int[count];
        
        Arrays.sort(arr);
        
        int idx = 0;
        for(int num : arr){
            if(num % divisor == 0){
                answer[idx++] = num;
            }
        }
        return answer;
    }
}