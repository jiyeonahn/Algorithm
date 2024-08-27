class Solution {
    public int[] solution(String s) {
        int[] answer = new int[s.length()];
        for(int i = 0; i < s.length(); i++){
            int idx = s.substring(0,i).lastIndexOf(s.charAt(i));
            answer[i] = idx == -1 ? -1 : s.substring(0,i).length() - idx;
            
        }
        return answer;
    }
}