class Solution {
    public int solution(int chicken) {
        int answer = 0;
        int coupon = 0;
        while(chicken >= 10){
            answer += chicken/10;
            coupon += chicken%10;
            chicken = chicken/10;
        }
    
        answer = answer + (chicken+coupon)/10 + ((chicken+coupon)/10+(chicken+coupon)%10)/10;
        return answer;
    }
}