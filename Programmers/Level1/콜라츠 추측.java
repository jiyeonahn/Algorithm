class Solution {
    public int solution(int num) {
        int cnt = 0;
        long lnum = num;
        while(lnum != 1){
            if(lnum % 2 == 0) lnum = lnum / 2;
            else lnum = lnum * 3 + 1;
            cnt++;
            if(cnt == 500){
                cnt = -1;
                break;
            }
        }
        return cnt;
    }
}