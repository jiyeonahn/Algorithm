class Solution {
    public int[] solution(String s) {
        int cnt = 0;
        int clearZero = 0;
        while(true){
            if("1".equals(s)) break;
            cnt++;
            clearZero += s.replace("1","").length();
            s = s.replace("0","");
            s = Integer.toBinaryString(s.length());
        }
        return new int[]{cnt, clearZero};
    }
}