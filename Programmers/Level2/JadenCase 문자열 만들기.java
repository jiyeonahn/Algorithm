class Solution {
    public String solution(String s) {
        //대문자 65~90 소문자 97~122
        int index = 0;
        s = s.toLowerCase();
        StringBuffer sb = new StringBuffer();
        for(int i = 0; i < s.length(); i++){
            if(s.substring(i,i+1).equals(" ")){
                sb.append(s.substring(i,i+1));
                index = 0;
                continue;
            }
            else if(index == 0){
                sb.append(s.substring(i,i+1).toUpperCase());
                index++;
            }
            else{
                index = 1;
                sb.append(s.substring(i,i+1));
            }

        }

        return sb.toString();
    }
}