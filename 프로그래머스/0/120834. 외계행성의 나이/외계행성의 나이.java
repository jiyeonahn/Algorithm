class Solution {
    public String solution(int age) {
        String answer = "";
        String[] arr = (age+"").split("");
        for(String num : arr){
            answer += (char)(Integer.parseInt(num) + 97);
        }

        return answer;
    }
}