class Solution {
    public String solution(String s, String skip, int index) {
        StringBuilder answer = new StringBuilder();
        for(int i = 0; i < s.length(); i++){
            char nextChar = s.charAt(i);
            int count = 0;
            while(count < index){
                nextChar++;
                if(nextChar > 'z'){
                    nextChar = 'a';
                }
                
                if(!skip.contains(String.valueOf(nextChar))) {
                    count++;
                }
            }
            
            answer.append(nextChar);
            
        }
        return answer.toString();
    }
}