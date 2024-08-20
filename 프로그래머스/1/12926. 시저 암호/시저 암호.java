class Solution {
    public String solution(String s, int n) {
        StringBuilder sb = new StringBuilder();
        for(char ch : s.toCharArray()){
            if(ch == ' '){
                sb.append(ch);
                continue;
            } 
            if(ch+n > 122 || (ch >= 'A' && ch <= 'Z' && ch+n > 90)) {
                sb.append((char)(ch+n-26));
            }
            else sb.append((char)(ch+n));
        }
        return sb.toString();
    }
}