class Solution {
    public int solution(int n) {
        int answer = 0;
        StringBuilder sb = new StringBuilder();
        while(n > 0){
            sb.append(n%3);
            n = n/3;
        }
        String revStr = sb.reverse().toString();
        
        for(int i = 0 ; i < revStr.length(); i++){
            answer += Math.pow(3,i) * Integer.parseInt(revStr.substring(i,i+1));
        }
            
        return answer;
    }
}