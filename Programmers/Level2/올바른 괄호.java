class Solution {
    boolean solution(String s) {
        int left = 0, right = 0;
        if(s.charAt(0) == ')' || s.charAt(s.length() - 1) == '(' || s.length() % 2 != 0)
            return false;

        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '(')
                left++;
            else
                right++;
            if(left < right)
                return false;
        }

        return true;
    }
}