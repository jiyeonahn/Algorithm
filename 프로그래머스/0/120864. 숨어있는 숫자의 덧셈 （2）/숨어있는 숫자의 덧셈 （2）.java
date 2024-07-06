class Solution {
    public int solution(String my_string) {
        int answer = 0;
        String numStr = "";
        for(int i = 0; i < my_string.length(); i++){
            if(my_string.charAt(i) >= '0' && my_string.charAt(i) <= '9'){
                numStr += my_string.charAt(i);
            }else{
                if(numStr.length() > 0){
                    answer += Integer.parseInt(numStr);
                    numStr = "";
                }
            }
        }
        if(numStr.length() > 0){
            answer += Integer.parseInt(numStr);
        }
        return answer;
    }
}