package Level1;

class Solution {
    public String solution(String phone_number) {
        int index = phone_number.length() - 4;
        String answer = phone_number.substring(index);
        StringBuffer sb = new StringBuffer();
        for(int i = 0; i < index; i++)
            sb.append("*");

        return sb.append(answer).toString();
    }
}
