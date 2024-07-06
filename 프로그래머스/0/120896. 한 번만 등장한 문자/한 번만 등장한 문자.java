class Solution {
    public String solution(String s) {
        String answer = "";
        int[] alpha = new int[26];
        for(int i = 0; i < s.length(); i++){
            alpha[s.charAt(i) - 97]++;
        }
        for(int i = 0; i < 26; i++){
            if(alpha[i] == 1){
                answer += (char)(i+97);
            }
        }
        return answer;
    }
}