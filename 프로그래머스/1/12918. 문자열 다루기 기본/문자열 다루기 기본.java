class Solution {
    public boolean solution(String s) {
        boolean answer = true;
        if(s.length() != 4 && s.length() != 6){
            answer = false;
        }
        s = s.replaceAll("[0-9]","");
        if(!"".equals(s)){
            answer = false;
        }
        return answer;
    }
}