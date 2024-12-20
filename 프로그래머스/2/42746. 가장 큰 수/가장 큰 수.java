import java.util.*;
class Solution {
    public String solution(int[] numbers) {
        String answer = "";
        String[] nums = new String[numbers.length];
        for(int i = 0; i < numbers.length; i++){
            nums[i] = String.valueOf(numbers[i]);
        }
        Arrays.sort(nums, (a,b) -> (b+a).compareTo(a+b));
        // for(int i = 0; i < numbers.length; i++){
        //     for(int j = i+1; j < numbers.length; j++){
        //         String temp = "";
        //         if((nums[i] + nums[j]).compareTo(nums[j] + nums[i]) < 0){
        //             temp = nums[i];
        //             nums[i] = nums[j];
        //             nums[j] = temp;
        //         }
        //     }
        // }
        
        for(String num : nums){
            answer += num;
        }
        
        if(answer.charAt(0) == '0'){
            return "0";
        }
        
        return answer;
    }
}