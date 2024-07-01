class Solution {
    public String solution(String rsp) {
        String answer = "";
        for(int i = 0; i < rsp.length(); i++){
            if("2".equals(rsp.substring(i,i+1))){
                answer += "0";
            }else if(("0".equals(rsp.substring(i,i+1)))){
                answer += "5";
            }else{
                answer += "2";
            }
        }
        return answer;
    }
}