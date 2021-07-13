class Solution {
    public int[] solution(long n) {
        String numString = String.valueOf(n);
        int[] answer = new int[numString.length()];
        int index = numString.length() - 1;
        for(int i = 0; i < numString.length(); i++){
            answer[i] = Integer.parseInt(numString.substring(index, index+1));
            index--;
        }
        return answer;
    }
}