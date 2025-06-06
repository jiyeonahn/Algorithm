class Solution {
    public String solution(String s, String skip, int index) {
        StringBuilder answer = new StringBuilder();
        for(int i = 0; i < s.length(); i++){
            char nextChar = s.charAt(i);
            
            for(int j = 0; j < index; j++){
                nextChar = (char)(nextChar+1);
                if(nextChar > 122){
                    nextChar = (char)(96+nextChar-122);
                }
                while(true){
                    if(!skip.contains(nextChar+"")){
                        break;
                    }
                    nextChar = (char)(nextChar+1);
                    if(nextChar > 122){
                        nextChar = (char)(96+nextChar-122);
                    }
                }
            }
            
            answer.append(nextChar);
            
        }
        return answer.toString();
    }
}