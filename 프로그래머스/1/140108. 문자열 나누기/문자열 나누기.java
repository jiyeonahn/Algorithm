class Solution {
    public int solution(String s) {
        int answer = 0;
        char x = s.charAt(0);
        int same = 0;
        int diff = 0;
        int idx = 0;
        while(idx < s.length()){
            if(x == s.charAt(idx)){
                same++;
            }else{
                diff++;
            }
            
            idx++;
            
            if(same == diff){
                if(idx >= s.length()) break;
                x = s.charAt(idx);
                
                same = 0;
                diff = 0;
                answer++;
            }
        }
        return answer+1;
    }
}