class Solution {
    boolean solution(String s) {
        int count = 0;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == 'p' || s.charAt(i) == 'P')
                count++;
            if(s.charAt(i) == 'y' || s.charAt(i) == 'Y')
                count--;
        }


        return count == 0;
    }
}