class Solution {
    public int solution(String my_string) {
        String operator = "";
        String[] nums = my_string.split(" ");
        int answer = Integer.parseInt(nums[0]);
        for(int i = 1; i < nums.length; i++){
            if("+".equals(nums[i]) || "-".equals(nums[i])){
                operator = nums[i];
            }else{
                if("+".equals(operator)){
                    answer += Integer.parseInt(nums[i]);
                }else{
                    answer -= Integer.parseInt(nums[i]);
                }
            }
        }
        return answer;
    }
}