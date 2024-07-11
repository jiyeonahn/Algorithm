class Solution {
    public int solution(int i, int j, int k) {
        int answer = 0;
        String numStr = "";
        for(int o = i; o <= j; o++){
            numStr += o;
        }
        for(int o = 0; o < numStr.length(); o++){
            if(numStr.substring(o,o+1).equals(k+"")){
                answer++;
            }
        }
        return answer;
    }
}