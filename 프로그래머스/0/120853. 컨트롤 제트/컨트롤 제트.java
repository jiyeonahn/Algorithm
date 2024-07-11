class Solution {
    public int solution(String s) {
        int answer = 0;
        String[] num = s.split(" ");
        for(int i = 0; i < num.length; i++){
           if("Z".equals(num[i])){
                answer = answer - Integer.parseInt(num[i-1]);
            }else{
               answer += Integer.parseInt(num[i]);
           }
        }
        return answer;
    }
}