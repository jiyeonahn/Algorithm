class Solution {
    public int[] solution(String s) {
        int[] answer = new int[s.length()];
        int idx = 0;
        for(int i = 0; i < s.length(); i++){
            idx = s.substring(0,i).lastIndexOf(s.charAt(i));
            answer[i] = idx == -1 ? -1 : i - idx;
            
        }
        return answer;
    }
}