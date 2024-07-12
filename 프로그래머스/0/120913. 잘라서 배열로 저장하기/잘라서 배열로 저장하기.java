class Solution {
    public String[] solution(String my_str, int n) {
        String[] answer = new String[(int)Math.ceil((float)my_str.length()/n)];
        int idx = 0;
        for(int i = 0; i < answer.length; i++){
            answer[i] = i == answer.length-1 ? my_str.substring(i*n) : my_str.substring(i*n,i*n+n);
        }
        return answer;
    }
}