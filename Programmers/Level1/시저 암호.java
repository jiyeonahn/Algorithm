class Solution {
    public String solution(String s, int n) {
        char[] a = s.toCharArray();
        for(int i = 0; i < s.length(); i++){
            if(a[i] == ' ') continue;
            for(int j = 0; j < n; j++){
                if(a[i] == 'z' || a[i] == 'Z')
                    a[i] -= 25;
                else
                    a[i] ++;
            }

        }
        String answer = new String(a);
        return answer;
    }
}