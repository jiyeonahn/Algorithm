class Solution {
    public String solution(String s) {
        String answer = "";
        String[] words = s.split("");
        int cnt = 0;
        for(String word : words){
            if(" ".equals(word)){
                cnt = 0;
                answer += word;
                continue;
            }
            if(cnt++%2 == 0){
                answer += word.toUpperCase();
            }else{
                answer += word.toLowerCase();
            }
        }
        
        
        return answer;
    }
}