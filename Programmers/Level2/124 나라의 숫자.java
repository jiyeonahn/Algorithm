class Solution {
    public String solution(int n) {
        String answer = "";
        int[] num = {4, 1, 2};
        int div = n;
        int index = 0;
        StringBuffer sb = new StringBuffer();
        while(div > 0){
            index = div % 3;
            div = div / 3 - 1;

            sb.insert(0,num[index]);
        }
        return sb.toString();
    }
}