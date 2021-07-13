class Solution {
    public String solution(int a, int b) {
        String[] day = {"THU","FRI","SAT","SUN","MON","TUE","WED"};
        int[] month = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int c = b;
        for(int i=0; i < a - 1; i++){
            c += month[i];
        }
        return day[c % 7];
    }
}