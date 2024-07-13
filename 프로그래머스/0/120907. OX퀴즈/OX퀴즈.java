class Solution {
    public String[] solution(String[] quiz) {
        String[] answer = new String[quiz.length];
        String[] nums = {};
        for(int i = 0; i < quiz.length; i++){
            nums = quiz[i].split(" ");
            if("+".equals(nums[1])){
                answer[i] = Integer.parseInt(nums[0]) + Integer.parseInt(nums[2]) == Integer.parseInt(nums[4]) ?  "O" : "X";
            }else{
                answer[i] = Integer.parseInt(nums[0]) - Integer.parseInt(nums[2]) == Integer.parseInt(nums[4]) ?  "O" : "X";
            }
        }
        return answer;
    }
}