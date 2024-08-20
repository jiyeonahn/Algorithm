class Solution {
    public String solution(String s, int n) {
        String answer = "";
        for(char ch : s.toCharArray()){
            if(ch == ' '){
                answer += ch;
                continue;
            } 
            if(ch+n > 122 || (ch >= 'A' && ch <= 'Z' && ch+n > 90)) {
                answer += ((char)(ch+n-26));
            }
            else answer += ((char)(ch+n));
        }
        return answer;
    }
}